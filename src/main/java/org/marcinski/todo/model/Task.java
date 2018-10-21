package org.marcinski.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Task {
    private String id;
    private String description;
    private LocalDateTime addingDateTime;
    private boolean done;
    private TaskPriority priority;

    public Task() {
        this.id = UUID.randomUUID().toString();
        this.addingDateTime = LocalDateTime.now();
        this.done = false;
    }
}
