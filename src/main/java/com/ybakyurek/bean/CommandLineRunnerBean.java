package com.ybakyurek.bean;

import com.ybakyurek.business.services.ITaskServices;

import com.ybakyurek.data.entity.TaskEntity;

import com.ybakyurek.data.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// Lombok
@RequiredArgsConstructor

@Configuration
@Log4j2
@Component
public class CommandLineRunnerBean {


    // Injection
    private final ITaskServices iTaskServices;
    private final ITaskRepository iTaskRepository;



    // CategoryName (Save)
    public TaskEntity taskEntitySave(String categoryName,String content, Boolean state) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskName(categoryName);
        taskEntity.setContent(content);
        taskEntity.setState(state);
        iTaskRepository.save(taskEntity);
        return taskEntity;
    }

    // Random Category
    public String[] randomCategory() {
        String[] randomData = new String[5];
        randomData[0] = "Market alisverisi";
        randomData[1] = "Kitap oku";
        randomData[2] = "kodlama egzersizi";
        randomData[3] = "spor";
        randomData[4] = "kosu";
        // döngüde rastgele bir tane category seçecek
        for (int i = 0; i < 5; i++) {
            taskEntitySave(randomData[i], "burasi random icerikler",false);
        }
        // döngüde rastgele bir tane category seçecek
        for (int i = 0; i < randomData.length; i++) {
            System.out.println(randomData[i]);
        }
        return randomData;
    }



    @Bean
    public CommandLineRunner taskCommandLineRunnerMethod() {
        return args -> {
            System.out.println("CommandLineRunner Çalıştı");
            log.info("CommandLineRunner Çalıştı");

            randomCategory();
        };
    }
}