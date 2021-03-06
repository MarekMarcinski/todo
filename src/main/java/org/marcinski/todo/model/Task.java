package org.marcinski.todo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.marcinski.todo.dto.TaskPriority;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime addingDateTime;
    private boolean done;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    public Task() {
        this.addingDateTime = LocalDateTime.now();
        this.done = false;
    }
}

