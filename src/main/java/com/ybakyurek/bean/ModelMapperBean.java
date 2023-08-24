package com.ybakyurek.bean;


/*
* ModelMapper DTO ve Entity sınıfları arasında veri dönüşümünü
* kolaylaştırmak için kullanılan bir Java kütüphanesidir.
* */
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //sınıfın Spring uygulamasının yapılandırmasına dahil edilecek yapılandırma sınıfı olduğunu belirtir.
public class ModelMapperBean {

    @Bean //bir bean üretme yöntemidir. modelMapperMethod() adında bir bean yöntemi tanımlayacak.
    //bu sayede spring'e asagidaki metodu tanimlamis olabiliriz. IOC/DI konseptleri dogrultusunda
    //metodun yonetimi framework'e devredilir. DI ile yaptigimizda ise cache'de yer acmadan yani = new Class
    //demeden obje olusturulabilir.
    /*
    * Bu yapılandırma sınıfı ile uygulamanın herhangi bir yerinde ModelMapper örneğini enjekte edebiliriz,
    * farklı sınıflar arasında veri taşıma veya dönüştürme işlemlerini gerçekleştirebiliriz.
     * */
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }
}
