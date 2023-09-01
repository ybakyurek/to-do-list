package com.ybakyurek.data.entity;

import com.ybakyurek.auditing.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@Log4j2

// ENTITY
@Entity
@Table(name = "task_todos")
// Category(1) Blog(N)
public class TaskEntity extends AuditingAwareBaseEntity implements Serializable {

    // serileştirme
    public static final Long serialVersionUID = 1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="task_id",unique = true,nullable = false,insertable = true,updatable = false)
    private Long taskId;

    // TASK NAME
    @Column(name = "task_name")
    private String taskName;

    // TASK CONTENT
    @Lob
    @Column(name = "task_content", length = 2000)
    private String content;

    // TASK CONTENT
    @Column(name = "task_state")
    private Boolean state;

    // DATE
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;


    // Constructor (parametresiz)
    public TaskEntity() {
    }

    // Constructor (parametreli)


    public TaskEntity(String taskName, String content, Boolean state) {
        this.taskName = taskName;
        this.content = content;
        this.state = state;
    }

    public void toggleState() {
        this.state = !this.state;
    }
} //end class
