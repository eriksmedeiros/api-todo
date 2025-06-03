package br.com.erik.toDoList.services;

import br.com.erik.toDoList.dtos.TaskDTO;
import br.com.erik.toDoList.models.TaskModel;
import br.com.erik.toDoList.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getTasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getStatus()))
                .toList();
    }

    public TaskModel saveTask(TaskDTO taskDTO) {
        TaskModel taskModel = new TaskModel(
                taskDTO.getTitle(),
                taskDTO.getStatus()
        );

        return taskRepository.save(taskModel);
    }

    public TaskModel editTask(TaskDTO taskDTO, UUID id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);

        if (taskModel.isPresent()) {
            taskModel.get().setTitle(taskDTO.getTitle());
            taskModel.get().setStatus(taskDTO.getStatus());
            return taskRepository.save(taskModel.get());
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    public String removeTask(UUID id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);

        if (taskModel.isPresent()) {
            taskRepository.delete(taskModel.get());
            return "Task deleted successfully";
        } else {
            throw new RuntimeException("Task not found");
        }
    }
}
