package com.motta.schedule;

import com.motta.service.TasksService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {

    private final TasksService tasksService;

    public TaskNotificationSchedule(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Scheduled(fixedRate = 60)
    public void checkAndNotifyTasks(){
        tasksService.sendNotificationForDueTasks();
    }

}
