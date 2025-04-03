package com.mascot.todo_app.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.mascot.todo_app.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public TaskRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public List<Task> findAll() {
        return dynamoDBMapper.scan(Task.class, new DynamoDBScanExpression());
    }

    public Task findById(String id) {
        return dynamoDBMapper.load(Task.class, id);
    }

    public void save(Task task) {
        dynamoDBMapper.save(task);
    }

    public Task getTaskById(String id){
        return dynamoDBMapper.load(Task.class, id);
    }

    public void deleteById(String id) {
        Task task = dynamoDBMapper.load(Task.class, id);
        if (task != null) {
            dynamoDBMapper.delete(task);
        }
    }
}