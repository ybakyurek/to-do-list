package com.ybakyurek.error;
/*
* Bu sınıf, API çağrıları sırasında oluşan hataları daha düzenli bir şekilde temsil etmek ve
* istemcilere daha fazla bilgi sağlamak amacıyla kullanılır.
* */



import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.Map;


/*
* Bu LOMBOK anotasyonu, sınıfın getter, setter, equals, hashCode ve toString metodlarını otomatik olarak oluşturur.
* Bu sayede kod tekrarını azaltır ve sınıfı daha basit hale getirir.
* */
@Data

/*
* Bu Jackson anotasyonu, JSON çıktısında null değeri olan alanların çıktıya dahil edilmemesini sağlar.
* Yani, JSON çıktısında null değeri olan alanlar görüntülenmez.
* */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // Pırasa Vali MESC
    // API çağrısının yapıldığı URL yolunu ifade eder.
    private String path;
    /*Eğer API çağrısı doğrulama hatası nedeniyle başarısız olduysa, bu alan doğrulama hatalarını içerir.
    Örnek olarak alan adı ve hatanın açıklaması gibi çiftlerden oluşan bir harita (map) kullanılıyor.*/
    private Map<String,String> validationErrors;
    //Hata mesajını veya açıklamasını içerir.
    private String message;
    //Hatanın türünü veya adını içerir. Örneğin, "Internal Server Error" gibi genel bir hata adı olabilir.
    private String error;
    //HTTP durum kodunu içerir. Örneğin, 404 veya 401 gibi.
    private int status;
    //API yanıtının oluşturulduğu tarih ve saati içerir.
    private Date systemDate;

    // Parametresiz Constructor
    public ApiResult() {
    }

    // Parametreli Constructor
    public ApiResult(String path, String message, int status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }
}
