package com.ybakyurek.data.repository;

import com.ybakyurek.data.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITaskRepository extends CrudRepository<TaskEntity,Long> {

    // Delivered Query (Kendi sorgumu yazdım)
    Optional<TaskEntity> findByTaskName(String taskName);
    List<TaskEntity> findByState(boolean state);

    List<TaskEntity> findByTaskNameContainingIgnoreCase(String keyword);
    List<TaskEntity> findByContentContainingIgnoreCase(String keyword);

}

