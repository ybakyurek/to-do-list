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

    // Task
    public String[] createTask() {
        String[] randomData = new String[5];
        randomData[0] = "Marketten Alınacaklar";
        randomData[1] = "Kitap Oku";
        randomData[2] = "Kodlama Egzersizi Yap";
        randomData[3] = "Koşuya Çık";
        randomData[4] = "Su İç";
        // Content
        taskEntitySave(randomData[0], "Su, muz, mısır",false);
        taskEntitySave(randomData[1], "Yüzüklerin Efendisi",true);
        taskEntitySave(randomData[2], "Java Spring",false);
        taskEntitySave(randomData[3], "Hergün akşam 8'de",true);
        taskEntitySave(randomData[4], "En az iki litre",true);

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
            createTask();
        };
    }
}