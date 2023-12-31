package com.ybakyurek.business.dto;

import com.ybakyurek.annotation.UniqueTaskName;
import com.ybakyurek.auditing.AuditingAwareBaseDto;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder
// Validation

public class TaskDto extends AuditingAwareBaseDto implements Serializable {

    // serileştirme
    public static final Long serialVersionUID=1L;

    // CATEGORY NAME
    // kendi Anonotation'ı yazdım.

    private String taskName;
    
    @Lob
    private String content;

    private Boolean state;
}
