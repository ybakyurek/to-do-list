package com.ybakyurek.data.repository;

import com.ybakyurek.data.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Asagidakiler bizim tercihlerimizle ilgili. Benzer islemlerde bunlar kullanilabilir. biz CRUD sectik.
// JpaRepository
// CrudRepository
// PagingAndSortingRepository

/*
*     @Repository: Bu anotasyon, bu arayüzün bir Spring bileşeni olduğunu belirtir.
* Bu sayede Spring, arayüzü tarama yaparak algılar ve gerekli işlemleri otomatik olarak gerçekleştirir.
*     extends CrudRepository<CategoryEntity, Long>:
* Bu ifade, CrudRepository arayüzünün miras alındığını belirtir.
* CrudRepository, temel CRUD işlemlerini gerçekleştirmek için gerekli metotları içeren bir arayüzdür.
* İlk parametre, işlem yapılacak nesne türünü (CategoryEntity) belirtir,
* ikinci parametre ise bu nesnenin kimlik (ID) türünü belirtir (burada Long).
*
* */
@Repository
public interface ICategoryRepository extends CrudRepository<CategoryEntity,Long> {
}
