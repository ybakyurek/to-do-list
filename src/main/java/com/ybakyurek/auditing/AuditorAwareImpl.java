package com.ybakyurek.auditing;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.Optional;

// LOMBOK
@Log4j2

/*
* Bu anotasyon, bu sınıfın bir Spring bileşeni olduğunu belirtir.
* Bu sayede Spring, bu sınıfı otomatik olarak tarama yaparak algılar ve kullanabilir hale getirir.
* Bu nesne Spring nesnesinin artık bir parçasıdır.
* */
@Component
public class AuditorAwareImpl implements AuditorAware<String> {


    /*
    * AuditorAware arayüzündeki getCurrentAuditor metodu burada override edilir.
    * */


    /*
    * AuditorAware arayüzünün bir parçası olarak uygulanmıştır.
    * Bu metot, mevcut kullanıcı bilgisini döndürmeyi amaçlar.
    * */
    @Override
    public Optional<String> getCurrentAuditor() {
        /*
        * SecurityContextHolder.getContext().getAuthentication(): Spring Security tarafından sağlanan
        * SecurityContextHolder nesnesi kullanılarak, sisteme giriş yapmış kullanıcının kimlik bilgilerini alır.
        * Database giriş yapmış kullanıcı bilgilerini göstermek
        * */
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        /* authentication != null && authentication.isAuthenticated():
        * Bu koşul, eğer bir kimlik bilgisi varsa ve kullanıcı oturum açmışsa doğru döner.
        * Sisteme girmiş kullanıcı  var mı
        * */
        if(authentication!=null && authentication.isAuthenticated()){
            System.out.println("Sisteme Girmiş "+ authentication.getName());
            log.info("Sisteme Girmiş "+ authentication.getName());
            log.info("Sisteme Girmiş "+ authentication.getPrincipal());
            return Optional.of(authentication.getName());
        }
        return Optional.of("ybakyurek.");
        /*
        * Eğer bir oturum açılmışsa, oturum açmış olan kullanıcının adını ve kimlik bilgilerini loglar
        * ve Optional nesnesi olarak döndürür.
        * Eğer bir oturum açılmamışsa, HamitM. adını içeren bir Optional nesnesi döndürülür.
        * */

    } //end getCurrentAuditor
} //end class
