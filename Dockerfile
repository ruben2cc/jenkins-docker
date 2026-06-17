FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/*.jar site.jar
CMD ["java", "-jar", "site.jar"]