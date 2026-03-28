FROM eclipse-temurin:17-jdk
WORKDIR /app

ENV ENV_DB_URL=132.344.12.12
ENV ENV_DB_URL:produccion
ENV ENV_DB_NAME:Produccion

COPY ./target/demodocker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
LABEL authors="asagrero"
ENTRYPOINT ["java", "-jar", "app.jar"]