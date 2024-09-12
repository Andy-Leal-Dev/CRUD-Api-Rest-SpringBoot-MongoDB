package dev.andy.api_rest_mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.andy.api_rest_mongodb.models.TaskModel;
import dev.andy.api_rest_mongodb.services.TaskServices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
public class TaskContoller {
    
    @Autowired
    private TaskServices taskServices;
    
    @GetMapping("/")
    public List<TaskModel> getTasks() {
        return taskServices.ListTask();
    }

    @GetMapping("/{id}")
    public TaskModel getTasksById(@PathVariable String id) {
        return taskServices.getTaskById(id);
    }

    @PostMapping("/Save")
    public TaskModel saveTask(@RequestBody TaskModel task) { 
        return this.taskServices.saveTask(task);
    }
    
    @PutMapping("/task/{id}")
    public ResponseEntity<?> putTaskById(@PathVariable String id, @RequestBody TaskModel task) {
        
        TaskModel taskActual = taskServices.getTaskById(id);
        taskActual.setAuthor_task(task.getAuthor_task());
        taskActual.setDescription_task(task.getDescription_task());
        taskActual.setTitle_task(task.getTitle_task());
        return ResponseEntity.ok(taskServices.saveTask(taskActual));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable String id){
        taskServices.deleteTask(id);
    }
        
}
