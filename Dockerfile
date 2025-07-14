FROM eclipse-temurin:17
COPY target/Transcations-0.0.1-SNAPSHOT.jar transactions.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/transactions.jar","--spring.profiles.active=dev"]
