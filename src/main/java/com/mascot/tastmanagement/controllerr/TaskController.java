package com.mascot.tastmanagement.controllerr;


import com.mascot.tastmanagement.model.Task;
import com.mascot.tastmanagement.service.TaskService;
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

    @GetMapping("/")
    public String home(Model model) {
     model.addAttribute("tasks", taskService.findAll());
     return "home";
    }

    @GetMapping("/add-task")
    public String addTask(Model model) {
     model.addAttribute("task", new Task());
     return "add-task";
    }

    @PostMapping("/save-task")
    public String saveTask(@ModelAttribute Task task) {
     task.setStatus(task.getStatus());
     taskService.save(task);
     return "redirect:/";
    }
    @GetMapping("/edit-task/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        try {
            Task task = taskService.getTaskById(id);
            if (task == null) {
                throw new RuntimeException("Task not found with ID: " + id);
            }
            model.addAttribute("task", task);
            return "edit-task";
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            model.addAttribute("errorMessage", "An error occurred while fetching the task.");
            return "error";
        }
    }

    @PostMapping("/update-task")
    public String updateTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/";
    }
    @GetMapping("/delete-task/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/";
    }
}
