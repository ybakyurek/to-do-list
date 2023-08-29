package com.ybakyurek.data.entity;

import com.ybakyurek.auditing.AuditingAwareBaseEntity;
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
* @Table(name = "tasks"): Bu anotasyon, sınıfın veritabanında hangi tabloya karşılık geldiğini belirtir.
* name parametresi ile tablo adı belirtilir.
* */
@Table(name = "tasks")
// task(N) Categories(1)
public class TaskEntity extends AuditingAwareBaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    /*
    * @Id: Bu anotasyon, taskId alanının birincil anahtar (primary key) olduğunu belirtir.
    * @GeneratedValue(strategy = GenerationType.IDENTITY): Bu anotasyon, taskId alanının otomatik olarak
    *   artan birincil anahtar olarak nasıl oluşturulacağını belirtir.
    * @Column: Bu anotasyon, sütun seviyesinde yapılandırmaları belirtir.
    *   Bu örnekte name, nullable, insertable ve updatable parametreleri ayarlanmıştır.
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskId", unique = true, nullable = false, insertable = true, updatable = false)
    private Long taskId;

    /*
    * @CreationTimestamp: Bu anotasyon, systemDate alanının otomatik olarak oluşturulduğu
    * tarih ve saat bilgisini temsil eder.
    * */
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    // TITLE
    @Column(name = "title", length = 500, columnDefinition = "varchar(500) default 'title'")
    private String title;

    // CONTENT
    @Lob
    @Column(name = "content", length = 500, columnDefinition = "varchar(500) default 'content'")
    private String content;

    // STATUS
    @Column(name = "state")
    private boolean state;


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
    *   Yani, bir task öğesinin sadece bir kategorisi olabilir.
    *   fetch parametresi, ilişkili nesnenin ne zaman yükleneceğini belirler.
    *   FetchType.LAZY, ilişkili nesnenin gerektiğinde yükleneceği anlamına gelir.
    *   optional parametresi, bu ilişkinin zorunlu olup olmadığını belirtir.
    *   false değeri, bir taskin mutlaka bir kategoriye sahip olması gerektiğini gösterir.
    * @JoinColumn(name="category_id", nullable = false):
    *   Bu anotasyon, veritabanında bu ilişkinin tutulacağı sütunu belirtir.
    *   name parametresi ile sütun adı belirtilir.
    *   nullable parametresi, bu sütunun boş geçilemez olduğunu belirtir.
    *   Yani, bir taskin mutlaka bir kategoriye ait olması gerektiği anlamına gelir.
    * Task ve Category Entity arasinda bir baglanti saglamamiz lazim
    * */

    // Constructor (Parametresiz)
    public TaskEntity() {
    }

    // Constructor (Parametreli)

}
