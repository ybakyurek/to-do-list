package com.ybakyurek.error;

import com.ybakyurek.assist.FrontendURL;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Lombok anotasyonu ile, sınıfın final alanlarına sahip olduğunda otomatik olarak bir constructor oluşturulur.
//3. Yolu kullanmak icin bunu yapiyoruz.
@RequiredArgsConstructor

//Sınıfın bir RESTful API Controller olduğunu belirtir.
@RestController

// API'ye gelen isteklere belirtilen origin (köken) adresinden gelen isteklere izin verilmesini sağlar.
// FrontEnt.REACT_URL burada tanımlanır.
@CrossOrigin(origins = FrontendURL.REACT_URL)

//Bu sınıf, ErrorController arayüzünü uygular ve özel hata işleme yöntemleri sağlar.
public class CustomErrorHandleWebRequest implements ErrorController {

    // ErrorController
    // ErrorAttributes
    // WebRequest

    private ApiResult apiResult;
    private String path;
    private String message;
    private int status;
    private Map<String,String> validationErrors;

    /*
    1.YOL (Field Injection)
    @Autowired
    private ErrorAttributes errorAttributes;

    2.YOL (Constructor Injection)
    private final ErrorAttributes errorAttributes;
    @Autowired
    public CustomErrorHandleWebRequest(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }
    */

    /*3.YOL (Constructor Lombok Injection)
    * ErrorAttributes arayüzünden türetilen bir nesne, hata durumları hakkında bilgi sağlar.
    * */
 private final ErrorAttributes errorAttributes;

    // http://localhost:4444/error
    //Bu metot, "/error" URL yoluna gelen istekleri yakalar.
    //Bu genellikle uygulamada meydana gelen hataları işlemek ve uygun hata yanıtlarını oluşturmak için kullanılır.
    @RequestMapping("/error")
    public ApiResult springMyHandleErrorMethod(WebRequest webRequest){

        //Bu metot, Spring Boot'un hata verilerini almak için kullanılır.
        //ErrorAttributeOptions aracılığıyla hangi verilerin alınacağı belirlenir.
        //Asagidaki olay Spring >=2.3'ten sonra kullanilabilir.

        /*Bu metot, hata verilerini almak için kullanılır.
        İlk parametre olarak WebRequest nesnesi ve ikinci parametre olarak ErrorAttributeOptions nesnesi alır.
        Bu metot, Map<String, Object> türünde bir harita (map) döndürür. Bu harita, hata verilerini içerir.*/
        Map<String,Object> attributes=errorAttributes.getErrorAttributes(
                webRequest,// nesnesi, hata ile ilgili talebin detaylarını taşır. Bu nesne, örneğin URL, istek parametreleri, istek başlıkları gibi bilgileri içerir.
                /*Bu metot, hata verilerinin nasıl alınacağını belirten bir ErrorAttributeOptions nesnesi oluşturur.
                Bu örnekte, hata mesajı (MESSAGE) ve bağlama hataları (BINDING_ERRORS) verilerinin alınacağı belirtiliyor. */
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS
                )
        ); //end attributes

        // Hata verileri alındıktan sonra, bu veriler status, message ve path gibi alanlara atanır.
        // Bu veriler, ApiResult sınıfının parametreli constructor'ı kullanılarak bir ApiResult nesnesi oluşturulur.
        status= (int) attributes.get("status");
        message= (String) attributes.get("message");
        path= (String) attributes.get("path");
        // public ApiResult(String path, String message, int status) {}
        apiResult=new ApiResult(path,message,status);


        //Eğer hatalar içeriyorsa, bu hatalar errors anahtarı altında bir List<FieldError> şeklinde alınır.
        //Bu hatalar validationErrors adlı bir HashMap içerisine dönüştürülerek ApiResult nesnesine atanır.
        if(attributes.containsKey("errors")){
            List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("errors");
            // HashMap oluştur
            validationErrors=new HashMap<>();
            // bütün hataları for each döngüsünde kullan
            for(FieldError temp :fieldErrorList){
                validationErrors.put(temp.getField(),temp.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationErrors);
        }
        return apiResult;
    }  // end  springMyHandleErrorMethod
} // end class
