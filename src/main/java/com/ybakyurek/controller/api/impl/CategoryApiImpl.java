package com.ybakyurek.controller.api.impl;

import com.ybakyurek.assist.FrontEnt;
import com.ybakyurek.business.dto.CategoryDto;
import com.ybakyurek.business.services.ICategoryServices;
import com.ybakyurek.controller.api.ICategoryApi;
import com.ybakyurek.error.ApiResult;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
/*
* Lombok tarafından sağlanan
* @RequiredArgsConstructor annotation'ı sayesinde, sınıfın bağımlılıkları constructor üzerinden enjekte edilir.
* @Log4j2 annotation'ı ile sınıfın loglaması ayarlanır.
* */
@RequiredArgsConstructor // Injection
@Log4j2

// API
/*
* @RestController annotation'ı ile sınıfın bir REST controller olduğu belirtilir.
* @RequestMapping annotation'ı ile bu controller'ın hangi URL yoluna ve sürüme hizmet edeceği belirtilir.
* */
@RestController
@RequestMapping("/category/api/v1")

/*
* @CrossOrigin annotation'ı ile bu API'nin hangi kaynaklardan gelen isteklere izin vereceği belirtilir.
* Örneğin, FrontEnt.REACT_URL adresinden gelen isteklere izin verildiği görülmektedir.
* */
@CrossOrigin(origins = FrontEnt.REACT_URL) // http://localhost:3000

/*
* ICategoryServices Enjeksiyonu:
* @RequiredArgsConstructor sayesinde,
* bu sınıfa ICategoryServices interface'inin implementasyonunun enjekte edileceği constructor
* otomatik olarak oluşturulur.
* */
public class CategoryApiImpl implements ICategoryApi<CategoryDto> {

    // Injection
    private final ICategoryServices iCategoryServices;
    private ApiResult apiResult;

    /*
    * @PostConstruct annotation'ı ile bu sınıfın constructor çağrıldıktan sonra ilk çalışacak metodu belirtilir.
    * Bu örnekte, apiResult adlı bir ApiResult nesnesi oluşturulur.
    * */
    @PostConstruct
    public void categoryPostConstruct() {
        apiResult = new ApiResult();
    }


    /*
    * Kategori oluşturma işlemini gerçekleştiren endpoint.
    * @PostMapping annotation'ı ile HTTP POST isteklerini yönlendiren metodun tanımı yapılır.
    * @Valid annotation'ı ile gelen verilerin doğrulamasının yapılacağı belirtilir.
    * Veriler @RequestBody ile alınır.
    * İşlem sonucu dönüş değeri olarak ResponseEntity kullanılır ve oluşturulan kategori DTO'su döndürülür.
    * */

    // CREATE
    // http://localhost:4444/category/api/v1/create
    @Override
    @PostMapping(value = "create")
    public ResponseEntity<?> categoryApiCreate(@Valid @RequestBody CategoryDto categoryDto) {
        // return new ResponseEntity<>(iCategoryServices.categoryServiceCreate(categoryDto), HttpStatus.OK);
        // return  ResponseEntity.status(HttpStatus.OK).body(iCategoryServices.categoryServiceCreate(categoryDto));
        // return  ResponseEntity.status(200).body(iCategoryServices.categoryServiceCreate(categoryDto));
        // return  ResponseEntity.ok().body(iCategoryServices.categoryServiceCreate(categoryDto));

        // iCategoryServices.categoryServiceCreate(categoryDto);
        // apiResult=new ApiResult("path","message",200);
        // return  ResponseEntity.ok().body(apiResult);
        return ResponseEntity.ok(iCategoryServices.categoryServiceCreate(categoryDto));
    }

    // LIST
    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiList() {
        return null;
    }

    // FIND
    @Override
    public ResponseEntity<CategoryDto> categoryApiFind(Long id) {
        return null;
    }

    // UPDATE
    @Override
    public ResponseEntity<CategoryDto> categoryApiUpdate(Long id, @Valid @RequestBody CategoryDto categoryDto) {
        return null;
    }

    // DELETE
    @Override
    public ResponseEntity<CategoryDto> categoryApiDelete(Long id) {
        return null;
    }

    ///////////////////////////////////////////////////////////////
    // ALL DELETE
    @Override
    public ResponseEntity<String> categoryApiAllDelete() {
        return null;
    }

    // SPEED DATA
    @Override
    public ResponseEntity<List<CategoryDto>> categoryApiSpeedData(int key) {
        return null;
    }
}
