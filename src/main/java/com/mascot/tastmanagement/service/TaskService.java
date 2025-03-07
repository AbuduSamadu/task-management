package com.mascot.tastmanagement.service;

import com.mascot.tastmanagement.model.Task;
import com.mascot.tastmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

}
