package com.ybakyurek.bean;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfigBean {

    @Bean
    //OpenAPI'i  API'in tanimlamasini ve tanitimini yapmak icin kullaniyoruz
    //mesela createUser, deleteUser vs.
    public OpenAPI openAPIMethod(){
        return new OpenAPI()
                .info(
                        new Info()
                                .description("Demo to-do-list project for Spring Boot ")
                                .version("v1")
                                .contact(new Contact().email("ybakyurek@gmail.com").url("url"))
                                .title("to-do-list")
                                .summary("To do list app-description ozeti aslinda")
//                                .termsOfService("Software INC")
                                .license(new License()
                                        .name("MIT License")
                                        .url("https://opensource.org/licenses/MIT"))); // MIT License URL
    }
}
