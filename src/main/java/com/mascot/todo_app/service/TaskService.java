package com.mascot.todo_app.service;

import com.mascot.todo_app.model.Task;
import com.mascot.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    //comment
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(String id) {
        taskRepository.deleteById(id);
    }

    public Task getTaskById(String id){
        return taskRepository.getTaskById(id);
    }

}
