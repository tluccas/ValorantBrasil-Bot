FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY --from=build /app/target/ValorantBrasil-1.0.jar bot.jar

ENTRYPOINT ["java", "-jar", "bot.jar"]
