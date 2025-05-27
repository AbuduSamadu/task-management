package com.mascot.todo_app.controller;


import com.mascot.todo_app.model.Status;
import com.mascot.todo_app.model.Task;
import com.mascot.todo_app.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "home";
    }

    @GetMapping("/add-task")
    public String addTask(Model model) {
        Task task = new Task();
        task.setStatus(Status.TODO);
        model.addAttribute("task", task);
        return "add-task";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task) {
        if(task.getStatus() == null){
            task.setStatus(Status.TODO);
        }
        taskService.save(task);
        return "redirect:/";
    }

    @GetMapping("/edit-task/{id}")
    public String editTaskForm(@PathVariable String id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return "redirect:/";
        }
        model.addAttribute("task", task);
        return "edit-task";

    }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Task task) {
        taskService.update(task);
        return "redirect:/";
    }

    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable String id) {
        taskService.deleteById(id);
        return "redirect:/";
    }
}
