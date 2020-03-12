# SB-JPA-ImageUpload

This is an image upload application built with Spring Boot and Spring Data JPA.

In order to run the application, clone or download it. You can import it into your preferred IDE or you can go to the location where it is saved/downloaded and run mvn clean spring-boot:run . The program will start up on localhost:8080.

To Insert Images in Database:
INSERT INTO images(id,photo) VALUES(1001,LOAD_FILE('C:/SB-JPA-ImageUpload/src/main/resources/images/GMC.jpg'));
INSERT INTO images(id,photo) VALUES(1002,LOAD_FILE('C:/SB-JPA-ImageUpload/src/main/resources/images/Ford.jpg'));

To View Images From Classpath:
http://localhost:8040/image/classpath
</br>
http://localhost:8040/image/classpath1

To View Images From Database:
http://localhost:8040/image/database/1001
</br>
http://localhost:8040/image/database1/1002
