FROM eclipse-temurin:17
COPY target//Transcations-0.0.1-SNAPSHOT.jar transactions.jar
ENTRYPOINT ["java","-jar","/transactions.jar","--spring.profiles.active=dev"]