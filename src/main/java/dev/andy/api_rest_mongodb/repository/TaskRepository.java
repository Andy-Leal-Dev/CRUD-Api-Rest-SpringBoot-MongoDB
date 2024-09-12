package dev.andy.api_rest_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dev.andy.api_rest_mongodb.models.TaskModel;

@Repository
public interface TaskRepository extends MongoRepository<TaskModel,String>{
    
}
