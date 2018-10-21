package org.marcinski.todo.controller;

import com.google.gson.Gson;
import org.marcinski.todo.dto.TaskDto;
import org.marcinski.todo.dto.TaskPriority;
import org.marcinski.todo.service.TaskService;

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

    private TaskService taskService = new TaskService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id")!= null && !req.getParameter("id").isEmpty()){
            Long id = Long.valueOf(req.getParameter("id"));
            taskService.deleteTask(id);
            resp.sendRedirect("task");
        }else {
            List<TaskDto> taskDtoList = getTasksFromCookie(req);
            req.setAttribute("task", taskDtoList);

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
            TaskDto taskDto = new TaskDto();
            taskDto.setDescription(description);
            taskDto.setPriority(priority);

            taskService.addTask(taskDto);
            resp.sendRedirect("task");
        }
    }

    private List<TaskDto> getTasksFromCookie(HttpServletRequest req) {
//        Cookie[] cookies = req.getCookies();
//        List<TaskDto> taskDtoList = new ArrayList<>();
//        for (Cookie c : cookies) {
//            String first4LetterOfCookieName = c.getName().substring(0,4);
//            if (first4LetterOfCookieName.equals("task")){
//                TaskDto taskDto = getTask(c.getValue());
//                taskDtoList.add(taskDto);
//            }
//        }
//        return taskDtoList;
        return taskService.getAllTasks();
    }

    private static TaskDto getTask(String decodedCookieValue) {
        String decoded = new String(Base64.getDecoder().decode(decodedCookieValue));
        Gson gson = new Gson();
        return gson.fromJson(decoded, TaskDto.class);
    }
}
