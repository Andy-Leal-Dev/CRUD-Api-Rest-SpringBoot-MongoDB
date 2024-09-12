package dev.andy.api_rest_mongodb.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.andy.api_rest_mongodb.models.TaskModel;
import dev.andy.api_rest_mongodb.repository.TaskRepository;

@Service
public class TaskServices {
    
        
    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> ListTask(){
        return taskRepository.findAll();
    }

    public TaskModel saveTask(TaskModel task){
        return taskRepository.save(task);
    }

    public TaskModel getTaskById(String id){
        return taskRepository.findById(id).get();
    }

    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }
}
