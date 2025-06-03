package br.com.erik.toDoList.dtos;

import java.util.UUID;

public class TaskDTO {
    private UUID id;
    private String title;
    private String status;

    public TaskDTO() {
    }

    public TaskDTO(UUID id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
