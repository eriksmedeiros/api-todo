package br.com.erik.toDoList.controllers;

import br.com.erik.toDoList.dtos.TaskDTO;
import br.com.erik.toDoList.models.TaskModel;
import br.com.erik.toDoList.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping("/add")
    public ResponseEntity<TaskModel> addTask(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.saveTask(taskDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable("id") UUID id, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.editTask(taskDTO, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") UUID id) {
        taskService.removeTask(id);
        return ResponseEntity.noContent().build();
    }
}