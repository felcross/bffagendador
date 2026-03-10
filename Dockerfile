FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY build/libs/bff-agendador-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8083
CMD ["java", "-jar", "/app/app.jar"]