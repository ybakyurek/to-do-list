package com.ybakyurek.auditing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter @Setter

// SUPER CLASS
@MappedSuperclass
@JsonIgnoreProperties(value = {"created_date,updated_date"},allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
abstract public class AuditingAwareBaseEntity  implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // AUDITING
    // KIM EKLEDİ ?
    @CreatedBy
    @Column(name = "created_user")
    protected String createdUser;

    // KİM NE ZAMAN EKLEDİ ?
    @CreatedDate
    @Column(name="created_date")
    protected Date createdDate;

    // KIM GÜNCELLEDİ ?
    @LastModifiedBy
    @Column(name = "updated_user")
    protected String updatedUser;

    // KİM NE ZAMAN GÜNCELLEDİ ?
    @LastModifiedDate
    @Column(name="updated_date")
    protected Date updatedDate;
} //end class
