# prueba
proyecto de prueba con SpringBoot - Java

Requerido : 
*  Java 21
*  Maven
*  Git
*  PostMan

Correr el proyecto:
*  clonar el proyecto (por consola CMD ejecutar ' git clone https://github.com/juanzorrilla/prueba.git ')
*  Acceder por CMD hasta el directorio del proyecto clonado
*  Ejecutar mvn clena instal -U para descargar las dependencias del proyecto
*  Ejecutar mvn spring-boot:run para levantar la aplicacion
*  En PostMan, abrir el archivo prueba.postman_collection que se encuentra en el directorio rais del proyecto y ejecutar el request
*  En el navegadore, ingresar a localhost:8080/h2-console - datos para conectarse:
    - JDBC URL : jdbc:h2:mem:prueba
    - user name : admin
    - password : admin
* Verificar si el registro se cargo en la tabla usaurio
