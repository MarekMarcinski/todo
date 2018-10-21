package org.marcinski.todo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TaskDto {

    private Long id;
    private String description;
    private LocalDateTime addingDateTime;
    private boolean done;
    private TaskPriority priority;

    public TaskDto() {
        this.addingDateTime = LocalDateTime.now();
        this.done = false;
    }
}
