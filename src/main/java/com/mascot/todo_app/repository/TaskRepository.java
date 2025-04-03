package com.mascot.todo_app.repository;

import com.mascot.todo_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    Task getTaskById(String id);
}
