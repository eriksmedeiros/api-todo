package br.com.erik.toDoList.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String title;
    private String status;

    public TaskModel() {
    }

    public TaskModel(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
