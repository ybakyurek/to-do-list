package com.ybakyurek.bean;

import com.ybakyurek.data.entity.TaskEntity;
import com.ybakyurek.data.entity.CategoryEntity;
import com.ybakyurek.data.repository.ITaskRepository;
import com.ybakyurek.data.repository.ICategoryRepository;
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
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // category Save
    /*
    * Bu metot, verilen categoryName ile bir CategoryEntity nesnesi oluşturur,
    * veritabanına kaydeder ve kaydedilen nesneyi döndürür.
    * */
    public CategoryEntity categoryEntitySave(String categoryName) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryName);
        iCategoryRepository.save(categoryEntity);
        return categoryEntity;
    }

    // Kullanıcıdan aldığım verileri database kaydetsin
    /*
    * Bu metot, kullanıcıdan kategori adını alarak bu kategorileri categoryEntitySave metoduyla kaydeder.
    * Bu adım, kullanıcı girişi ile kategorileri oluşturmanızı sağlar.
    * */
    public void userData() {
        for (int i = 1; i <= 3; i++) {
            //String user= JOptionPane.showInputDialog(i+".ci Kategori Lütfen Kategori adını yazınız ");
           Scanner scanner = new Scanner(System.in);
            System.out.println("\n");
            System.out.println(i + ".ci Kategori Lütfen Kategori adını yazınız");
            String userName = scanner.nextLine().toUpperCase();
            categoryEntitySave(userName);
        }
    }

    // Kategori Listesi
    /*
    * Bu metot, tüm kategori nesnelerini veritabanından çekip döndürür.
    * */
    public Iterable<CategoryEntity> categoryEntitiesList() {
        return iCategoryRepository.findAll();
    }


    /*
    * Bu metot, önce userData metodu ile kategorileri oluşturur,
    * sonra bu kategorileri alıp task nesneleri ile ilişkilendirir ve veritabanına kaydeder.
    * Son olarak, tüm kategori ve task nesnelerini konsola yazdırır.
    * */
    @Bean
    @Transactional // save, delete, update
    public void taskCategorySave() {
        // Kategory oluştursun ve listelesin
//        userData();
        categoryEntitySave("MARKET");
        categoryEntitySave("KISISEL");
        categoryEntitySave("IS");
        Iterable<CategoryEntity> categoryListIterable = categoryEntitiesList();
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        categoryListIterable.forEach(categoryEntityList::add);

        // task oluşturmak (1)
        TaskEntity taskEntity1=new TaskEntity();
        taskEntity1.getTaskEntityEmbeddable().setTitle("Alisveris");
        taskEntity1.getTaskEntityEmbeddable().setContent("Ekmek,makarna,sut");
        taskEntity1.getTaskEntityEmbeddable().setStatus(false);
        if(categoryEntityList!=null){
            taskEntity1.setRelationCategoryEntity(categoryEntityList.get(0)); //ilk kategoriyi
            iTaskRepository.save(taskEntity1);
        }


        // task oluşturmak (2)
        TaskEntity taskEntity2=new TaskEntity();
        taskEntity2.getTaskEntityEmbeddable().setTitle("Kitap Oku");
        taskEntity2.getTaskEntityEmbeddable().setContent("Gunde 30 dk ya da 20 sayfa kitap oku");
        taskEntity2.getTaskEntityEmbeddable().setStatus(true);
        if(categoryEntityList!=null){
            taskEntity2.setRelationCategoryEntity(categoryEntityList.get(1)); //ilk kategoriyi
            iTaskRepository.save(taskEntity2);
        }

        // task oluşturmak (3)
        TaskEntity taskEntity3=new TaskEntity();
        taskEntity3.getTaskEntityEmbeddable().setTitle("Kodlama Egzersizi");
        taskEntity3.getTaskEntityEmbeddable().setContent("Gunde 30 dk ya da 2 problem");
        taskEntity3.getTaskEntityEmbeddable().setStatus(true);
        if(categoryEntityList!=null){
            taskEntity3.setRelationCategoryEntity(categoryEntityList.get(2)); //ilk kategoriyi
            iTaskRepository.save(taskEntity3);
        }

        // TaskListesi
        categoryEntityList.forEach(System.out::println);
        System.out.println(taskEntity1);
        System.out.println(taskEntity2);
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
            taskCategorySave();
        }; //end return
    } //end CommandLineRunnerBean method
} // end class
