package br.com.erik.toDoList.controllers;

import br.com.erik.toDoList.dtos.TaskDTO;
import br.com.erik.toDoList.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.saveTask(taskDTO));
    }
}