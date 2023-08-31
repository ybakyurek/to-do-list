package com.ybakyurek.business.dto;

import com.ybakyurek.annotation.UniqueTaskName;
import com.ybakyurek.auditing.AuditingAwareBaseDto;
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
    @UniqueTaskName
    @NotEmpty(message = "{task.validation.constraints.NotNull.message}")
    @Size(min=2,message = "{task.least.validation.constraints.NotNull.message}")
    private String taskName;

    private String content;

    private Boolean state;
}
