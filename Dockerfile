FROM amazoncorrecto:17-alpine.jdk

COPY target/mealapp-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar" , "/app.jar"]