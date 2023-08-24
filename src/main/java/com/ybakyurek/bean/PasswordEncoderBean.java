package com.ybakyurek.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderBean {

    @Bean
    /*
    * PasswordEncoder, kullanıcı parolalarını güvenli bir şekilde saklamak için kullanılan ve
    * parola doğrulaması yapmak için kullanılan bir arayüzdür.
    * Parolaları doğrudan saklamak yerine, şifreleme algoritmaları kullanarak şifrelenmiş bir biçimde saklar.
    * Bu sayede, parolaların güvenliği artar ve
    * potansiyel bir veri ihlalinde bile kullanıcıların parolaları açığa çıkmaz.
    *"BCrypt" algoritmasını kullanarak parolaları güvenli bir şekilde şifreler ve doğrular.
     * */
    public PasswordEncoder passwordEncoderMethod(){
        return new BCryptPasswordEncoder();
    }
}
