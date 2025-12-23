FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/FinSmart-0.0.1-SNAPSHOT.jar app/FinSmart-0.0.1.jar

EXPOSE 8080

CMD ["java", "-jar", "app/FinSmart-0.0.1.jar"]