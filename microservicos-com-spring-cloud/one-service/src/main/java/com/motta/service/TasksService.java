package com.motta.service;

import com.motta.dto.NotificationRequest;
import com.motta.model.TasksEntity;
import com.motta.openfeign.NotificationClient;
import com.motta.repository.TasksRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public TasksService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public TasksEntity saveTask(TasksEntity tasksEntity){
        return tasksRepository.save(tasksEntity);
    }

    public void sendNotificationForDueTasks(){
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TasksEntity> dueTasks = tasksRepository.findTasksDueWithinDeadline(deadline);
        for(TasksEntity task : dueTasks){
            notificationClient.sendNotification(
                    new NotificationRequest(
                            "Task Due",
                            "Your task '" + task.getTitle() + "' is due today."
                    )
            );
            task.setNotified(true);
        }
    }



}
