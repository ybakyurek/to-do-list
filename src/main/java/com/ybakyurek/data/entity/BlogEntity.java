package com.ybakyurek.data.entity;

import com.ybakyurek.auditing.AuditingAwareBaseEntity;
import com.ybakyurek.data.BlogEntityEmbeddable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@Log4j2
@ToString

/*
* @Entity: Bu anotasyon, sınıfın bir JPA varlık sınıfı olduğunu belirtir.
* Bu sınıf, bir veritabanı tablosu ile ilişkilendirilecek ve bu tabloya veri kaydedebilecek.
* */
@Entity
/*
* @Table(name = "blogs"): Bu anotasyon, sınıfın veritabanında hangi tabloya karşılık geldiğini belirtir.
* name parametresi ile tablo adı belirtilir.
* */
@Table(name = "blogs")
// Blog(N) Categories(1)
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    /*
    * @Id: Bu anotasyon, blogId alanının birincil anahtar (primary key) olduğunu belirtir.
    * @GeneratedValue(strategy = GenerationType.IDENTITY): Bu anotasyon, blogId alanının otomatik olarak
    *   artan birincil anahtar olarak nasıl oluşturulacağını belirtir.
    * @Column: Bu anotasyon, sütun seviyesinde yapılandırmaları belirtir.
    *   Bu örnekte name, nullable, insertable ve updatable parametreleri ayarlanmıştır.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id", unique = true, nullable = false, insertable = true, updatable = false)
    private Long blogId;


    //@Embedded: Bu anotasyon, BlogEntityEmbeddable sınıfının gömülü (embedded) bir bileşen olduğunu belirtir.
    @Embedded
    private BlogEntityEmbeddable blogEntityEmbeddable = new BlogEntityEmbeddable();

    /*
    * @CreationTimestamp: Bu anotasyon, systemDate alanının otomatik olarak oluşturulduğu
    * tarih ve saat bilgisini temsil eder.
    * */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;


   /*
   @Transient // Database olmasın ama Javada olsun yani database'de olmuyor.
    private String justJava;
    */

    /*
    * @ManyToOne: Bu anotasyon, CategoryEntity sınıfıyla birçoktan bir ilişkinin olduğunu belirtir.
    * Bu örnekte fetch, optional ve JoinColumn gibi parametreler belirtilmiştir.
    * */

    /*
    * @ManyToOne(fetch = FetchType.LAZY, optional = false):
    *   Bu anotasyon, relationCategoryEntity alanının birçoktan bir ilişkiyi temsil ettiğini belirtir.
    *   Yani, bir blog öğesinin sadece bir kategorisi olabilir.
    *   fetch parametresi, ilişkili nesnenin ne zaman yükleneceğini belirler.
    *   FetchType.LAZY, ilişkili nesnenin gerektiğinde yükleneceği anlamına gelir.
    *   optional parametresi, bu ilişkinin zorunlu olup olmadığını belirtir.
    *   false değeri, bir blogun mutlaka bir kategoriye sahip olması gerektiğini gösterir.
    * @JoinColumn(name="category_id", nullable = false):
    *   Bu anotasyon, veritabanında bu ilişkinin tutulacağı sütunu belirtir.
    *   name parametresi ile sütun adı belirtilir.
    *   nullable parametresi, bu sütunun boş geçilemez olduğunu belirtir.
    *   Yani, bir blogun mutlaka bir kategoriye ait olması gerektiği anlamına gelir.
    * */
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="category_id",nullable = false)
    CategoryEntity relationCategoryEntity;

    // Constructor (Parametresiz)
    public BlogEntity() {
    }

    // Constructor (Parametreli)
    public BlogEntity(BlogEntityEmbeddable blogEntityEmbeddable, CategoryEntity relationCategoryEntity) {
        this.blogEntityEmbeddable = blogEntityEmbeddable;
        this.relationCategoryEntity = relationCategoryEntity;
    }
}
