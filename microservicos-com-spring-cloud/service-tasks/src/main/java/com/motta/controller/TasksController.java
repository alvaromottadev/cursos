package com.motta.controller;

import com.motta.model.TasksEntity;
import com.motta.service.TasksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public ResponseEntity<TasksEntity> createTask(@RequestBody TasksEntity tasksEntity){
        TasksEntity savedTask = tasksService.saveTask(tasksEntity);
        return ResponseEntity.ok(savedTask);
    }

}
