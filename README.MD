# Todo Uygulaması 

## Proje Tanımı

Bu proje, Java Spring backend, React frontend ve MySQL veritabanını kullanarak geliştirilen bir Todo uygulamasını içerir. Bu uygulama, kullanıcıların görevleri yönetmelerine olanak tanır ve temel işlevler sunar: görev oluşturma, güncelleme, silme ve durum değiştirme.

## Başlangıç

Projeyi yerel bir geliştirme ortamında çalıştırmak için aşağıdaki adımları izleyin.

### Gereksinimler

Projeyi çalıştırmak için aşağıdaki gereksinimlere ihtiyacınız vardır:

- Java JDK 17 veya daha yeni bir sürüm
- Node.js ve npm (Node Paket Yöneticisi)
- MySQL veritabanı
- Ayrıca proje bağımlılıkları için [pom.xml](https://github.com/ybakyurek/to-do-list/blob/main/pom.xml) ve [application.properties](https://github.com/ybakyurek/to-do-list/blob/main/src/main/resources/application.properties) dosyalarına bakabilir.

### Proje Demosu

##### ANA SAYFA</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Main.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>GÖREV LİSTESİ</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Task.png?raw=true" width="500">

##### <u>GÖREV</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/View.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>GÜNCELLE</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Update.png?raw=true" alt="Resim Açıklaması" width="500">



### Kurulum

1. Bu depoyu yerel makinenize klonlayın:

```bash
git clone https://github.com/ybakyurek/to-do-list.git
```

2. Backend'i başlatın: Intellij Idea Ultimate Edition kullanmanızı tavsite ederim

```bash
cd backend
./mvnw spring-boot:run
```

3. Frontend'i başlatın: VSCode kullanmanızı tavsiye ederim.

```bash
cd frontend
node -v //Versiyon Kontrolü
npm -v  //Versiyon Kontrolü
npx create-react-app frontend  
npm i axios  
npm install react-router-dom --save 
npm i i18next --save 
npm i react-i18next --save 
npm start
```

4. MySQL veritabanınızı oluşturun ve `application.properties` dosyasında veritabanı bağlantı ayarlarını yapılandırın:(Mevcut dosya içerisindeki bilgiler aşağıdadır)

```properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/todo?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=password
```

5. Veritabanına gerekli tabloyu oluşturmak için backend'i başlatın.

Uygulama şimdi http://localhost:3000 adresinde çalışıyor olmalıdır. Tarayıcıdan bu URL'yi ziyaret ederek uygulamayı kullanmaya başlayabilirsiniz.

## Kullanım

Uygulama, aşağıdaki temel işlevlere sahiptir:

- **Görev Ekleme**: Yeni bir görev eklemek için "Yeni Görev" kısmında olan alanı doldurarak "Ekle" düğmesine tıklayarak görevi kaydedin.

- **Görev Güncelleme**: Varolan bir görevi güncellemek için, görevin olduğu satırda ve güncelle sütünunda yer alan işarete tıklayarak düzenleme moduna geçin. Ardından bilgileri güncelleyin ve "Güncelle" düğmesine tıklayarak değişiklikleri kaydedin.

- **Görev Silme**: Bir görevi silmek için görevin olduğu satırda ve sil sütünunda yer alan işarete tıklayarak ya da "Göster" işaretine tıklayarak çıkan alanda "Sil" butonuna tıklayarak silin.

- **Durum Değiştirme**: Görevin durumunu tamamlandı veya tamamlanmadı olarak değiştirmek için görevin "Durum" alanına tıklayın .

- **Görevleri Listeleme**: Tüm görevleri görüntülemek için görev listesinin üstünde bulunan butonları kullanabilirsiniz.  "Hepsi", "Bitenler" ve "Yapılacaklar" şeklinde 3 buton bulunmaktadır.

- **Görevleri Silme**: Tüm görevleri  silmek için Hepsini Sil" ya da biten görevleri silmek için "Bitenleri Sil" düğmesine tıklayın. Bu alan görev listesinin altında yer almaktadır.

## API Endpointleri

Bu uygulama ayrıca aşağıdaki API endpointlerini sunar:

- `POST /task/api/v1/create`: Yeni bir görev ekler.
- `GET /task/api/v1/list`: Tüm görevleri listeler.
- `GET /task/api/v1/find/{id}`: Belirli bir görevi ID'ye göre alır.
- `GET /task/api/v1/list/by-state/{state}`: Belirli bir görevi duruma göre alır.
- `GET /task/api/v1/search/{keyword}`: Anahtar kelimeye göre görevleri arar.
- `PUT /task/api/v1/update/{id}`: Belirli bir görevi günceller.
- `PUT /task/api/v1/toggle-state/{id}`: Belirli bir görevin durumunu değiştirir.
- `DELETE /task/api/v1/delete/{id}`: Belirli bir görevi siler.
- `DELETE /task/api/v1/delete/by-state/{state}`: Belirli bir durumda olan tüm görevleri siler.
- `DELETE /task/api/v1/delete/all`: Tüm görevleri siler.

API endpointlerini kullanarak bu işlevleri programatik olarak da gerçekleştirebilirsiniz.

## Katkıda Bulunma

Bu proje techcareer.net tarafından düzenlenen eğitmenliğini Sayın Hamit Mızrak'ın yaptığı **Full-Stack Bootcamp** kapsamında hazırlanmıştır.

## Lisans

Bu proje [MIT lisansı](LICENSE) altında lisanslanmıştır. Daha fazla bilgi için lisans dosyasını kontrol edin.
