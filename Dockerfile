FROM eclipse-temurin:17

WORKDIR /app

EXPOSE 8080

ARG JAR_FILE=marketplace-0.0.1.jar

COPY $JAR_FILE marketplace-app.jar

ENTRYPOINT ["java", "-jar", "marketplace-app.jar"]


