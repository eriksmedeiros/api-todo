package br.com.erik.toDoList.services;

import br.com.erik.toDoList.dtos.TaskDTO;
import br.com.erik.toDoList.models.TaskModel;
import br.com.erik.toDoList.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
                taskDTO.getDescription(),
                taskDTO.isCompleted()
        );

        return taskRepository.save(taskModel);
    }
}
