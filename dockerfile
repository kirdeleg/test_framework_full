FROM maven:3.8.8-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Виконуємо лише компіляцію проекту
RUN mvn clean compile

# Встановлюємо ENTRYPOINT, який дозволяє передавати аргументи до mvn
ENTRYPOINT ["mvn"]