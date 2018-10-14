package org.marcinski.todo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private String description;
    private LocalDateTime addingDateTime;
    private boolean done;
    private TaskPriority priority;
}
