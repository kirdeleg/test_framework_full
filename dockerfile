FROM maven:3.8.8-eclipse-temurin-17

WORKDIR /app

COPY pom.xml .
COPY src ./src

# Створюємо директорію для результатів Allure
RUN mkdir /allure-results

# Виконуємо лише компіляцію проекту
RUN mvn clean compile

ENTRYPOINT ["mvn"]