# MealApp Backend 

Backend desarrollado en Java y Spring Boot para la aplicación **MealApp**, un sistema de gestión de pedidos de almuerzos que permite a los usuarios explorar, seleccionar y pedir platos, y a los administradores gestionar menús y pedidos.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot** (para la estructura del backend)
- **Spring Security** (para autenticación y autorización)
- **MySQL** (base de datos)
- **Flyway** (para migraciones de base de datos)
- **Maven** (para gestión de dependencias)

## Instalación y Configuración

### Requisitos Previos

- **Java 17**
- **Maven**
- **MySQL**
- **Git**

### Pasos de Instalación

1. **Clona el repositorio**:
2. **Crear una base de datos en MySQL llamada mealapp_prep**

   El proyecto esta configurado para que esta base de datos se cree automaticamente pero por las dudas podes seguir este paso.
  
3. **Configura las proppierties del proyecto:**
   
   Hay tres archivos proppierties, el primero corresponde a las propiedades generales del proyecto, tambien hay uno para desarrollo y otro para producción
   Te recomiendo tener el spring.profiles.active=dev para utilizar el perfil de desarrollo ya que este tiene todos los inserts migrados por flyway.
   Configura tus variables de entorno ${VARIABLES}, podes agregar variables de entorno para mas seguridad o simplemente sustituir ${VARIABLES} por un valor. 
   
   ```proppierties
   spring.profiles.active=dev
   spring.application.name=mealapp
   sever.error.include-stacktrace=never
   server.port=8080

   #Cambia el dia y la hora a partir del cual pueden hacerse pedidos
   mealapp.pedidoSemanal.fecha.apertura.dia=MONDAY
   mealapp.pedidoSemanal.fecha.apertura.hora=08
   mealapp.pedidoSemanal.fecha.apertura.minutos=00

   #Cambia el dia y la hora limite para realizar o modificar pedidos
   mealapp.pedidoSemanal.fecha.cierre.dia=THURSDAY
   mealapp.pedidoSemanal.fecha.cierre.hora=16
   mealapp.pedidoSemanal.fecha.cierre.minutos=00

   jwt.expiration.time.seconds=86400
   jwt.secret.key=${MEALAPP_CLAVE_SECRETA_FIRMA_TOKENS}
   ```
   
   El archivo aplicattion-dev.proppierties es el que tenes que modificar para levantar correctamente el proyecto

    ```proppierties
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=${DB_URL_DEV}?createDatabaseIfNotExist=true&serverTimezone=UTC
    spring.datasource.username=${DB_USER_DEV}
    spring.datasource.password=${DB_PASSWORD_DEV}
    
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.format_sql=false
    
    sever.error.include-stacktrace=never
    spring.flyway.locations=classpath:db/migration-dev
    ```
    
  3. **Compila y ejecuta la aplicación:**     

      Al ejecutar la aplicación flyway se va a encargar de crear las tablas e insertar los datos ejecutando los scripts que hay en el proyecto.
      Si tienes un IDE como IntelliJ solo hace falta darle a play y todo se ejecutará automaticamente

     ```bash
     mvn clean install
     mvn spring-boot:run
     ```

     El servidor estará disponible en http://localhost:8080.

  ## Seguridad
  Este proyecto utiliza JWT (JSON Web Token) para autenticar usuarios. Los usuarios pueden iniciar sesión para obtener un token, que deberán incluir en el encabezado Authorization de las solicitudes protegidas.

    
