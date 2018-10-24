package org.marcinski.todo.controller;

import org.marcinski.todo.dto.TaskDto;
import org.marcinski.todo.dto.TaskPriority;
import org.marcinski.todo.service.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            List<TaskDto> taskDtoList = getTasksFromDb();
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

    private List<TaskDto> getTasksFromDb() {
        return taskService.getAllTasks();
    }
}
