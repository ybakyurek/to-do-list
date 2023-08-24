package com.ybakyurek.auditing;

/*
 * Bir veritabanı tablosundaki denetim izleme (auditing) bilgilerini taşıyan bir temel veri transfer nesnesi (DTO)
 * amacı, nesnelerin ne zaman oluşturulduğunu, ne zaman güncellendiğini ve
 * kim tarafından oluşturulup güncellendiğini izlemek ve saklamak.
 * Bu sınıfın amacı, veritabanında hangi nesnelerin ne zaman oluşturulduğu ve güncellendiği gibi  izleme bilgilerini saklamaktır.
 * Bu bilgiler, denetim izleme gereksinimlerini karşılamak ve izlenebilirliği sağlamak amacıyla kullanılır.
 * Bu tür bir denetim izleme, özellikle çok kullanıcılı uygulamalarda, güvenlik gereksinimlerini desteklemek ve
 * hataları tespit etmek için önemlidir.
 * */


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
abstract public class AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    /*
     * Nesneye ait benzersiz kimlik numarasını temsil eder.
     * Bu alan genellikle veritabanı tablosundaki primere anahtar (primary key) karşılık gelir.
     * */
    private Long id;

    /*
     * Nesnenin oluşturulduğu tarih ve saat bilgisini taşır.
     * @Builder.Default anotasyonu ile öntanımlı bir değer atanmıştır.
     * */
    @Builder.Default
    private Date systemDate = new Date(System.currentTimeMillis());


    /*
     * Nesneyi kimin oluşturduğunu temsil eder. Kim ekledi'ye cevap buradadir.
     * Bu alan @JsonIgnore anotasyonu ile işaretlenmiştir,
     * yani bu alanın değeri JSON dönüşümlerinde gösterilmeyecektir.
     * (Backentte veri giderken)*/
    @JsonIgnore
    protected String createdUser;


    //Nesnenin ne zaman oluşturulduğunu temsil eder.
    @JsonIgnore
    protected Date createdDate;

    //Nesneyi kimin güncellediğini temsil eder.
    protected String updatedUser;

    //Nesnenin ne zaman güncellendiğini temsil eder.
    protected Date updatedDate;
}
