FROM eclipse-temurin:17-jdk
WORKDIR /app

COPY ./target/demodocker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
LABEL authors="asagrero"
ENTRYPOINT["java", "-jar", "app.jar"]