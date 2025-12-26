FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/FinSmart-*.jar app/FinSmart-*.jar

EXPOSE 8080

CMD ["java", "-jar", "app/FinSmart-*.jar"]