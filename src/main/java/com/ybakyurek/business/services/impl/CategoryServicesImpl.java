package com.ybakyurek.business.services.impl;

/*
* Bu sınıf, kategori (Category) nesneleri için CRUD (Create, Read, Update, Delete)
* işlemlerini gerçekleştirmek üzere tasarlanmış bir hizmet (service) sınıfı olan CategoryServicesImpl'i temsil eder.
* Bu hizmet sınıfı, ICategoryServices arayüzünü uygular ve
* kategori işlemlerini gerçekleştirmek üzere gerekli metotları içerir.
* */

import com.ybakyurek.bean.ModelMapperBean;
import com.ybakyurek.business.dto.CategoryDto;
import com.ybakyurek.business.services.ICategoryServices;
import com.ybakyurek.data.entity.CategoryEntity;
import com.ybakyurek.data.repository.ICategoryRepository;
import com.ybakyurek.exception.TaskNotFoundException;
import com.ybakyurek.exception.YbakyurekException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;




// LOMBOK
@RequiredArgsConstructor // Injection icin gerekli
@Log4j2

// SERVICE katmani oldugunu gosteriyoruz.
@Service
public class CategoryServicesImpl implements ICategoryServices<CategoryDto, CategoryEntity> {

    // Injection
    private final ICategoryRepository iCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    /*
    * Entity nesnesini DTO nesnesine dönüştürme işlemini yapar.
    * ModelMapper ile Entity nesnesini CategoryDto nesnesine dönüştürür.
    * */
    @Override
    public CategoryDto entityToDto(CategoryEntity categoryEntity) {
        return modelMapperBean.modelMapperMethod().map(categoryEntity, CategoryDto.class);
    }

    /*
    * DTO nesnesini Entity nesnesine dönüştürme işlemini yapar.
    * ModelMapper ile CategoryDto nesnesini CategoryEntity nesnesine dönüştürür.
    * */
    @Override
    public CategoryEntity dtoToEntity(CategoryDto categoryDto) {
        return modelMapperBean.modelMapperMethod().map(categoryDto, CategoryEntity.class);
    }

    /////////////////////////////////////////////////////////////////////
    // CREATE
    /*
    *  Yeni bir kategori oluşturma işlemini gerçekleştirir.
    * Gelen DTO nesnesini Entity nesnesine dönüştürüp veritabanına kaydeder,
    * ardından oluşturulan kategorinin ID ve sistem tarihini DTO nesnesine ekler.
    * */
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceCreate(CategoryDto categoryDto) {
        if (categoryDto != null) {
            CategoryEntity dtoToEntityChange = dtoToEntity(categoryDto);
            CategoryEntity categoryEntity = iCategoryRepository.save(dtoToEntityChange);
            // kaydettikten sonra id alsın döndersin
            categoryDto.setId(categoryEntity.getCategoryId());
            categoryDto.setSystemDate(categoryEntity.getSystemDate());
        } else {
            throw new NullPointerException("Category Dto null");
        }
        return categoryDto;
    }

    // LIST
    /*
    * Tüm kategorilerin listesini getirme işlemini gerçekleştirir.
    * Veritabanından tüm kategorileri çekip her birini
    * Entity nesnesinden DTO nesnesine dönüştürerek bir liste olarak sunar.
    * */
    @Override
    public List<CategoryDto> categoryServiceList() {
        // CategoryEntity List
        Iterable<CategoryEntity> categoryEntitiesList = iCategoryRepository.findAll();

        //CategoryDto List
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        // Bu döngü EntityList'i DtoList'e çevirsin
        for (CategoryEntity entity : categoryEntitiesList) {
            CategoryDto categoryDto = entityToDto(entity);
            categoryDtoList.add(categoryDto);
            // eğer Database maskelemek yapmak istiyorsak Bcrypted kullanabiliriz
        }
        return categoryDtoList;
    }

    // FIND

    /*
    * Belirli bir kategoriyi bulma işlemini gerçekleştirir.
    * Verilen ID'ye ait kategoriyi veritabanından çeker,
    * bulunamazsa TaskNotFoundException hatası fırlatır ve
    * bulunan kategoriyi Entity nesnesinden DTO nesnesine dönüştürerek sunar.
    * */
    @Override
    public CategoryDto categoryServiceFind(Long id) {
        // 1.YOL  optinal get , isPresent
        /*
        Optional<CategoryEntity> categoryFindEntity= iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDto(categoryFindEntity.get());
        if(categoryFindEntity.isPresent()){
            return categoryDto;
        }
        */

        // 2.YOL
        CategoryEntity categoryEntity = null;
        if (id != null && id != 0) {
            categoryEntity = iCategoryRepository.findById(id)
                    .orElseThrow(() -> new TaskNotFoundException(id + " Nolu ID Bulunmadı !!!!"));
        } else if (id == null)
            throw new YbakyurekException("Category id bull değerdir");
        return entityToDto(categoryEntity);
    }

    // UPDATE
    /*
    * Bir kategoriyi güncelleme işlemini gerçekleştirir.
    * Verilen ID'ye ait kategoriyi bulur,
    * DTO nesnesini Entity nesnesine dönüştürüp günceller ve
    * son halini DTO nesnesine dönüştürerek sunar.
    * */
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceUpdate(Long id, CategoryDto categoryDto) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null) {
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            categoryEntity.setCategoryName(categoryDto.getCategoryName());
            iCategoryRepository.save(categoryEntity);
        }
        return categoryDto;
    }

    // DELETE
    /*
    * Bir kategoriyi silme işlemini gerçekleştirir.
    * Verilen ID'ye ait kategoriyi bulur,
    * Entity nesnesini DTO nesnesine dönüştürüp siler ve
    * silinen kategoriyi DTO nesnesi olarak sunar.
    *
    * */
    @Override
    @Transactional // create, delete, update
    public CategoryDto categoryServiceDelete(Long id) {
        // Öncelikle Nesneyi bul
        CategoryDto categoryFindDto = categoryServiceFind(id);
        if (categoryFindDto != null) {
            CategoryEntity categoryEntity = dtoToEntity(categoryFindDto);
            iCategoryRepository.delete(categoryEntity);
        }
        return categoryFindDto;
    }

    //////////////////////////////////////////////////////////////////////////
    // ALL DELETE
    /*
    * Tüm kategorileri silme işlemini gerçekleştirir.
    * Veritabanındaki tüm kategorileri siler ve silinen veri sayısını döner.
    * */
    @Override
    public String categoryServiceAllDelete() {
        iCategoryRepository.deleteAll();
        return "Silinen veri sayısı: " + categoryServiceList().size();
    }

    // SPEED DATA
    /*
    * Hızlıca kategori verileri oluşturma işlemini gerçekleştirir.
    * Belirtilen sayıda kategori DTO nesnesi oluşturup veritabanına kaydeder ve
    * oluşturulan DTO nesnelerini bir liste olarak sunar.
    * */
    @Override
    public List<CategoryDto> categoryServiceSpeedData(Long key) {
        CategoryDto categoryDto = null;
        List<CategoryDto> categoryDtoList=new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= key; i++) {
            categoryDto = new CategoryDto();
            categoryDto.setCategoryName("category adı: " + i);
            categoryDtoList.add(categoryDto);
            CategoryEntity categoryEntity=dtoToEntity(categoryDto);
            iCategoryRepository.save(categoryEntity);
            count++;
        }
        return categoryDtoList;
    }

} //end class
