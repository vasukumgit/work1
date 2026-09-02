# =========================
# Stage 1: Build
# =========================
FROM maven:3.9-eclipse-temurin-23 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests -U


# =========================
# Stage 2: Runtime
# =========================
FROM eclipse-temurin:23-jre

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 81

ENTRYPOINT ["java", "-jar", "app.jar"]

