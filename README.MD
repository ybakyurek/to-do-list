# Todo Uygulaması 

## Proje Tanımı

Bu proje, Java Spring backend, React frontend ve MySQL veritabanını kullanarak geliştirilen bir Todo uygulamasını içerir. Bu uygulama, kullanıcıların görevleri yönetmelerine olanak tanır ve temel işlevler sunar: görev oluşturma, güncelleme, silme ve durum değiştirme.

### Proje Demosu

##### ANA SAYFA</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Main.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>GÖREV LİSTESİ</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Task.png?raw=true" width="500">

##### <u>GÖREV</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/View.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>GÜNCELLE</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Update.png?raw=true" alt="Resim Açıklaması" width="500">

## Başlangıç

Projeyi yerel bir geliştirme ortamında çalıştırmak için aşağıdaki adımları izleyin.

### Gereksinimler

Projeyi çalıştırmak için aşağıdaki gereksinimlere ihtiyacınız vardır:

- Java JDK 17 veya daha yeni bir sürüm

- Node.js ve npm (Node Paket Yöneticisi)

- MySQL veritabanı

- Ayrıca proje bağımlılıkları için [pom.xml](https://github.com/ybakyurek/to-do-list/blob/main/pom.xml) ve [application.properties](https://github.com/ybakyurek/to-do-list/blob/main/src/main/resources/application.properties) dosyalarına bakabilir.

  

### Kurulum

1. Bu depoyu yerel makinenize klonlayın:

```bash
git clone https://github.com/ybakyurek/to-do-list.git
```

2. Backend'i başlatın: Intellij Idea Ultimate Edition kullanmanızı tavsite ederim

```bash
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

## UML

##### <u>ALL</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/all.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>ENTITY</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Entity.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>ITaskRepo</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/ITaskRepo.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>ITaskAPI</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/TasAPI.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>Services</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/taskServices.png?raw=true" alt="Resim Açıklaması" width="500">



##### <u>DTO</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/DTO.png?raw=true" alt="Resim Açıklaması" width="500">





## Katkıda Bulunanlar

Bu proje techcareer.net tarafından düzenlenen eğitmenliğini Sayın Hamit Mızrak'ın yaptığı **Full-Stack Bootcamp** kapsamında hazırlanmıştır.

## Lisans

Bu proje [MIT lisansı](LICENSE) altında lisanslanmıştır. 







# Todo Application

## Project Description

This project includes a Todo application developed using Java Spring for the backend, React for the frontend, and MySQL for the database. This application allows users to manage their tasks and provides essential functionalities such as task creation, update, deletion, and status change.

### Project Demo

##### HOME PAGE

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Main.png?raw=true" alt="Image Description" width="500">



##### <u>Task List</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Task.png?raw=true" width="500">

##### <u>Task</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/View.png?raw=true" alt="Image Description" width="500">



##### <u>Update</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Update.png?raw=true" alt="Image Description" width="500">

## Getting Started

Follow the steps below to run the project in a local development environment.

### Requirements

To run the project, you need the following requirements:

- Java JDK 17 or a newer version.

- Node.js and npm (Node Package Manager).

- MySQL database.

- You can check the project dependencies in [pom.xml](https://github.com/ybakyurek/to-do-list/blob/main/pom.xml) and the configuration for the database connection in [application.properties](https://github.com/ybakyurek/to-do-list/blob/main/src/main/resources/application.properties).

  

### Installation

1. Clone this repository to your local machine:

```bash
git clone https://github.com/ybakyurek/to-do-list.git
```

2. Start the backend: It is recommended to use Intellij Idea Ultimate Edition.

```bash
./mvnw spring-boot:run
```

3. Start the frontend: It is recommended to use VSCode.

```bash
cd frontend
node -v //Version Check
npm -v  //Version Check
npx create-react-app frontend  
npm i axios  
npm install react-router-dom --save 
npm i i18next --save 
npm i react-i18next --save 
npm start
```

4. Create your MySQL database and configure the database connection in the `application.properties` file (existing information is provided below):

```properties
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/todo?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=password
```

5. Start the backend to create the necessary table in the database.

The application should now be running at http://localhost:3000. You can start using the application by visiting this URL in your web browser.

## Usage

The application offers the following core functionalities:

- **Task Creation**: Add a new task by filling out the fields in the "New Task" section and clicking the "Add" button.

- **Task Update**: To update an existing task, enter the edit mode by clicking on the checkbox in the row where the task is located and in the update column. Then, update the information and click the "Update" button to save the changes.

- **Task Deletion**: Delete a task by clicking on the checkbox in the row where the task is located and in the delete column, or click the "Show" button in the modal that appears and then click the "Delete" button.

- **Status Change**: Click on the "Status" field of a task to change its status between completed and not completed.

- **List Tasks**: Use the buttons at the top of the task list to view all tasks, completed tasks, or tasks that need to be done.

- **Delete Tasks**: Click the "Delete All" button to delete all tasks, or click the "Delete Completed" button to delete completed tasks. This area is located at the bottom of the task list.

## API Endpoints

This application also provides the following API endpoints:

- `POST /task/api/v1/create`: Add a new task.
- `GET /task/api/v1/list`: List all tasks.
- `GET /task/api/v1/find/{id}`: Get a specific task by ID.
- `GET /task/api/v1/list/by-state/{state}`: Get tasks by status.
- `GET /task/api/v1/search/{keyword}`: Search for tasks by keyword.
- `PUT /task/api/v1/update/{id}`: Update a specific task.
- `PUT /task/api/v1/toggle-state/{id}`: Change the status of a specific task.
- `DELETE /task/api/v1/delete/{id}`: Delete a specific task.
- `DELETE /task/api/v1/delete/by-state/{state}`: Delete all tasks with a specific status.
- `DELETE /task/api/v1/delete/all`: Delete all tasks.

You can use these API endpoints

 to perform these functionalities programmatically.

## UML Diagrams

##### <u>ALL</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/all.png?raw=true" alt="Image Description" width="500">



##### <u>ENTITY</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/Entity.png?raw=true" alt="Image Description" width="500">



##### <u>ITaskRepo</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/ITaskRepo.png?raw=true" alt="Image Description" width="500">



##### <u>ITaskAPI</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/TasAPI.png?raw=true" alt="Image Description" width="500">



##### <u>Services</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/taskServices.png?raw=true" alt="Image Description" width="500">



##### <u>DTO</u>

<img src="https://github.com/ybakyurek/techCareerAssignments/blob/main/img/DTO.png?raw=true" alt="Image Description" width="500">



## Contributors

This project was prepared as part of the **Full-Stack Bootcamp** organized by techcareer.net and instructed by Mr. Hamit Mızrak.

## License

This project is licensed under the [MIT License](LICENSE).
