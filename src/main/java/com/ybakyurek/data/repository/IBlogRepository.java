package com.ybakyurek.data.repository;

// JpaRepository
// CrudRepository
// PagingAndSortingRepository

import com.ybakyurek.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {

    // Delivered Query
    BlogEntity findBlogEntityByBlogEntityEmbeddableHeader(String header);
}
