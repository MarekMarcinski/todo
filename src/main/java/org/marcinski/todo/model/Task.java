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
    private UUID uuid;
    private String description;
    private LocalDateTime addingDateTime;
    private boolean done;
    private TaskPriority priority;

    public Task() {
        this.uuid = UUID.randomUUID();
        this.addingDateTime = LocalDateTime.now();
        this.done = false;
    }
}
