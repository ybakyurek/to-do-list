package com.ybakyurek.business.dto;

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
@Data //Lombok anotasyonu, sınıf için getter, setter, equals, hashCode ve toString
@NoArgsConstructor //Lombok anotasyonu, parametresiz bir constructor
@AllArgsConstructor //Lombok anotasyonu, tüm alanları içeren bir constructor
@Builder //Lombok anotasyonu, Builder deseni ile nesne oluşturmayı sağlar.
@Log4j2 //Lombok anotasyonu, sınıfa Log4j2 adında bir logger nesnesi ekler.
    // Bu logger nesnesi, sınıf içindeki loglama işlemleri için kullanılabilir.

public class BlogDto extends AuditingAwareBaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;


    /*
    * @NotEmpty anotasyonu, header alanının boş olmamasını sağlar,
    * @Size(min=10) ise alanın en az 10 karakter uzunluğunda olmasını zorlar ve
    * hata durumunda belirtilen mesajları gösterir.
    * Buradaki validation mesajlari ayni zamanda validationMessages.properties
        * icerisinde gosterilebilir.
        * Curly brackets kullanarak ifade edebiliriz.
    * */
    // HEADER
    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    @Size(min=10,message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String header;

    // CONTENT
    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min=10,message = "{blog.content.least.validation.constraints.NotNull.message}")
    private String content;
}
