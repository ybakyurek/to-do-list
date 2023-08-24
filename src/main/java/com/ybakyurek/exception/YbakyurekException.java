package com.ybakyurek.exception;

/*
Exception handle edilebilecek hatalarken, error outOfMemory gibi handle edilemeyecek hatalardir.
200 OK:İstek başarılı bir şekilde gerçekleşti ve sunucu tarafından istenilen kaynak veya işlem istemciye doğru şekilde döndü.
    Bu kod genellikle GET isteklerinin başarılı olduğunu ifade eder.

* 201,400,401,404 seklinde 4 adet hata class'i olusturduk
201 Created: İstek başarılı bir şekilde gerçekleşti ve sunucu tarafından yeni bir kaynak oluşturuldu.
    Bu genellikle POST isteklerinin sonucunu ifade eder. Örneğin, yeni bir kayıt oluşturulduğunda kullanılır.
400 Bad Request: İstek, sunucu tarafından anlaşılamadı veya işlenemedi.
   Genellikle istemcinin gönderdiği veri formatı veya parametrelerde bir sorun olduğunda kullanılır.
401 Unauthorized: İstek için kimlik doğrulama gereklidir veya kimlik doğrulama başarısız oldu.
   İstek yapan kullanıcının yetkisi yok veya oturum açmamış olabilir.
404 Not Found: İstek yapılan kaynak bulunamadı. Sunucu istenen kaynağı bulamıyor ise bu durum kodunu döner.
*/
public class YbakyurekException extends RuntimeException{
    public YbakyurekException(String message) {
        super(message);
    }
}
