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

    public List<TaskModel> getTasks() {
        return taskRepository.findAll();
    }

    public TaskModel saveTask(TaskDTO taskDTO) {
        TaskModel taskModel = new TaskModel(
                taskDTO.getName(),
                taskDTO.getStatus()
        );

        return taskRepository.save(taskModel);
    }

    public TaskModel editTask(TaskDTO taskDTO, UUID id) {
        Optional<TaskModel> taskModel = taskRepository.findById(id);

        if (taskModel.isPresent()) {
            taskModel.get().setName(taskDTO.getName());
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
