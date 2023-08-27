package com.ybakyurek.data.repository;

// JpaRepository
// CrudRepository
// PagingAndSortingRepository

import com.ybakyurek.data.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends CrudRepository<TaskEntity,Long> {

    // Delivered Query
    TaskEntity findTaskEntityByTaskEntityEmbeddableTitle(String title);
}
