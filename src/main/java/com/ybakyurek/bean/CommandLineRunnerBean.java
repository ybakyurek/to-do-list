package com.ybakyurek.bean;

import com.ybakyurek.data.entity.TaskEntity;
import com.ybakyurek.data.repository.ITaskRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//eski commit icin deneme

// Lombok
/*
* Bu anotasyon, Lombok tarafından sağlanır ve sınıfın final olarak işaretlenmiş tüm alanları için bir constructor oluşturur.
* Bu constructor, bu alanlara bağımlılıkları enjekte etmek için kullanılır.
* */
@RequiredArgsConstructor

/*
* Bu anotasyon, bu sınıfın bir Spring yapılandırma sınıfı olduğunu belirtir.
* Bu sınıf içerisinde Spring bean'lerini oluşturabilir ve yapılandırabilirsiniz.
* */
@Configuration

/*
* Bu anotasyon, Lombok tarafından sağlanır ve sınıfa Log4j2 tabanlı bir logger ekler.
* */
@Log4j2

/*
* Bu anotasyon, bu sınıfın bir Spring bileşeni olduğunu belirtir.
* Spring, bu bileşeni tarama yaparak algılar ve uygun yerlerde kullanır.
* */
@Component
public class CommandLineRunnerBean {


    /*
    *  Bu alanlar, sınıf içinde kullanılacak bağımlılıkları temsil eder.
    * Bu bağımlılıklar, Spring tarafından enjekte edilir.
    * */
    // Injection
    private final ITaskRepository iTaskRepository;
    private final ModelMapperBean modelMapperBean;

    // category Save
    /*
    * Bu metot, verilen categoryName ile bir CategoryEntity nesnesi oluşturur,
    * veritabanına kaydeder ve kaydedilen nesneyi döndürür.
    * */





    /*
    * Bu metot, önce userData metodu ile kategorileri oluşturur,
    * sonra bu kategorileri alıp task nesneleri ile ilişkilendirir ve veritabanına kaydeder.
    * Son olarak, tüm kategori ve task nesnelerini konsola yazdırır.
    * */
    @Bean
    @Transactional // save, delete, update
    public void taskSave() {
        // Kategory oluştursun ve listelesin


        // task oluşturmak (1)
        TaskEntity taskEntity1=new TaskEntity();
        taskEntity1.setTitle("market");
        taskEntity1.setContent("Ekmek,makarna,sut");
        taskEntity1.setState(false);
        iTaskRepository.save(taskEntity1);



        // task oluşturmak (2)
        TaskEntity taskEntity2=new TaskEntity();
        taskEntity2.setTitle("Kitap Oku");
        taskEntity2.setContent("Gunde 30 dk ya da 20 sayfa kitap oku");
        taskEntity2.setState(true);
        iTaskRepository.save(taskEntity2);


        // task oluşturmak (3)
        TaskEntity taskEntity3=new TaskEntity();
        taskEntity3.setTitle("Kodlama Egzersizi");
        taskEntity3.setContent("Gunde 30 dk ya da 2 problem");
        taskEntity3.setState(true);
        iTaskRepository.save(taskEntity3);

    }

    // CLR
    /*
    * Bu metot, CommandLineRunner arayüzünün bir örneğini oluşturarak içerisindeki kodu çalıştırır.
    * Bu metot, uygulama başladığında otomatik olarak çalıştırılır.
    * */
    public CommandLineRunner commandLineRunnerMethod() {
        return args -> {
            System.out.println("DATA444444444444");
            log.info("Data set oluşturulmuştur.");
            taskSave();
        }; //end return
    } //end CommandLineRunnerBean method
} // end class
