FROM maven:3.8.8-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean compile

ENTRYPOINT ["mvn", "test"]