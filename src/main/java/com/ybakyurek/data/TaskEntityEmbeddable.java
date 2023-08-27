package com.ybakyurek.data;
/*
* Bu yapı, BlogEntity sınıfında @Embedded anotasyonu ile kullanılarak,
* BlogEntityEmbeddable sınıfının özellikleri BlogEntity sınıfına gömülerek kullanılabilir.
* Bu sayede, kod tekrarını azaltabilir, verileri mantıklı bir şekilde gruplayabilir ve okunabilirliği artırabilir.
* Örneğin, bir blog öğesinin içeriğini, başlığını ve resmini bir arada tutarak daha düzenli bir yapı oluşturabilir.
* Buraya image ve title gelince duzenli olmasi icin degisiklik yapmistik.
* */

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
@Getter
@Setter

@Embeddable
public class TaskEntityEmbeddable {

    // TITLE
    @Column(name = "title", length = 500, columnDefinition = "varchar(500) default 'başlık yazılmadı...'")
    private String title;

    // CONTENT
    @Lob
    private String content;

    // STATUS
    private Boolean status;
}
