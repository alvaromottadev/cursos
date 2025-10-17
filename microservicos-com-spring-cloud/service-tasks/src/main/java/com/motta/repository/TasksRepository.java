package com.motta.repository;

import com.motta.model.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TasksRepository extends JpaRepository<TasksEntity, Long> {

    @Query("SELECT t FROM Task t WHERE t.dueDate <= :deadline and t.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadline);

}
