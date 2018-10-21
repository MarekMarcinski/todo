package org.marcinski.todo.controller;

import com.google.gson.Gson;
import org.marcinski.todo.model.Task;
import org.marcinski.todo.model.TaskPriority;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@WebServlet("/task")
public class TaskController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!= null && !req.getParameter("id").isEmpty()){
            String cookieId = req.getParameter("id");
            Cookie cookie = new Cookie("task"+cookieId, "");
            cookie.setMaxAge(1);
            resp.addCookie(cookie);
            resp.sendRedirect("task");
        }else {
            List<Task> taskList = getTasksFromCookie(req);
            req.setAttribute("task", taskList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        String priorityString = req.getParameter("priority");
        if (description != null && !description.isEmpty() && priorityString != null) {

            TaskPriority priority = TaskPriority.valueOf(priorityString);
            Task task = new Task();
            task.setDescription(description);
            task.setPriority(priority);

            Gson gson = new Gson();
            String taskString = gson.toJson(task);
            String codedTask = Base64.getEncoder().encodeToString(taskString.getBytes());
            Cookie taskCookie = new Cookie("task" + task.getId(), codedTask);
            resp.addCookie(taskCookie);
            resp.sendRedirect("task");
        }
    }

    private List<Task> getTasksFromCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        List<Task> taskList = new ArrayList<>();
        for (Cookie c : cookies) {
            String first4LetterOfCookieName = c.getName().substring(0,4);
            if (first4LetterOfCookieName.equals("task")){
                Task task = getTask(c.getValue());
                taskList.add(task);
            }
        }
        return taskList;
    }

    private static Task getTask(String decodedCookieValue) {
        String decoded = new String(Base64.getDecoder().decode(decodedCookieValue));
        Gson gson = new Gson();
        return gson.fromJson(decoded, Task.class);
    }
}
