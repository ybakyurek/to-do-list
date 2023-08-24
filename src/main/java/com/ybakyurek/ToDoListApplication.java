package com.ybakyurek;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import java.util.TimeZone;


// Mongo aktif etmek ici
// @EnableMongoRepositories

// Aspect aktif etmek icin
// @EnableAspectJAutoProxy(proxyTargetClass = true)

// Asenkron açmak icin
// @EnableAsync

// SCAN
// @EntityScan(basePackages = "com.hamitmizrak.data.entity") //Entity bulamadığı zaman
// @EnableJpaRepositories(basePackages = "com.hamitmizrak.data.repository") //Repository bulamadığı zaman

// Spring Cache aktif etmek gerekiyor.
// @EnableCaching


/*
*	Spring Data JPA ile otomatik denetim (auditing) özelliğini etkinleştirmek için kullanılır.
*	Bu özellik sayesinde, veritabanında yapılan işlemlerin (oluşturma, güncelleme)
*	hangi kullanıcı tarafından	ve ne zaman gerçekleştirildiğini otomatik olarak kaydedebilirsiniz.
*/
// Auditin Aktif etmek
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")



/*
* bir Spring Boot uygulamasının başlatılmasını yapılandırmak için kullanılıyor.
* Uygulama başlatılırken belirli otomatik yapılandırmaları devre dışı bırakmayı amaçlar.
* @SpringBootApplication annotasyonu genellikle Spring Boot uygulamalarının ana sınıfında kullanılır.
* Bu annotasyon, birçok farklı otomatik yapılandırmayı içeren bir dizi Spring Boot annotasyonunu bir araya getirir.
*
*
* */
// Spring Security
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class ToDoListApplication {


	//Bu, uygulamanın varsayılan zaman dilimini ayarlamak amacıyla kullanılabilecek bir adımdır
	//@PostConstruct metodu, bileşenin inşa sürecinden sonra başlatma işlemlerini gerçekleştirmek için kullanılır.
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}


	public static void main(String[] args) {


		// devtools active isActive
		// System.setProperty("spring.devtools.restart.enabled","true");

		// PORT Ayarlamak
        /*
        SpringApplication app = new SpringApplication(TurgutUniversitySpringAllInOneApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
         */

		//Disables headless JOptionPane
		System.setProperty("java.awt.headless", "false");

		SpringApplication.run(ToDoListApplication.class, args);
	}

}
