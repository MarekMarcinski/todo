package org.marcinski.todo.service;

import org.marcinski.todo.dao.TaskDao;
import org.marcinski.todo.dto.TaskDto;
import org.marcinski.todo.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private static TaskDao taskDao = new TaskDao();

    public List<TaskDto> getAllTasks(){
        List<Task> allTasks = taskDao.getAllTasks();
        List<TaskDto> taskDtos = new ArrayList<>();

        if(allTasks != null) {
            for (Task task : allTasks) {
                TaskDto taskDto = getTaskDto(task);
                taskDtos.add(taskDto);
            }
        }
        return taskDtos;
    }

    public void addTask(TaskDto taskDto){
        Task task = getTask(taskDto);
        taskDao.createTask(task);
    }

    public void deleteTask(Long id){
        taskDao.deleteTask(id);
    }

    private TaskDto getTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setDescription(task.getDescription());
        taskDto.setPriority(task.getPriority());
        taskDto.setAddingDateTime(task.getAddingDateTime());
        taskDto.setDone(task.isDone());
        return taskDto;
    }

    private Task getTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setDescription(taskDto.getDescription());
        task.setAddingDateTime(taskDto.getAddingDateTime());
        task.setPriority(taskDto.getPriority());
        task.setDone(taskDto.isDone());
        return task;
    }
}
