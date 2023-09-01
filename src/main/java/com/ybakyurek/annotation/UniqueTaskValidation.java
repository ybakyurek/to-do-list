package com.ybakyurek.annotation;

import com.ybakyurek.data.repository.ITaskRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

// LOMBOK
@RequiredArgsConstructor

// Annotation
public class UniqueTaskValidation implements ConstraintValidator<UniqueTaskName,String> {

    // Injection
    private final ITaskRepository iTaskRepository;

    // Database'de bu kategori isminden var mı ?
    @Override
    public boolean isValid(String taskName, ConstraintValidatorContext constraintValidatorContext) {
        Boolean isOtherTaskName= iTaskRepository.findByTaskName(taskName).isPresent();
        //Eğer database böyle bir category adı varsa bilgilendirme yapsın
        if(isOtherTaskName){
            return false;
        }
        return true;
    }
}
