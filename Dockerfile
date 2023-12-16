FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean packages -DSkipTests

FROM openjdk:17.0.1-jdk-slim
COPY __frombuild /target/media-app-apis-0.0.1-SNAPSHOT.jar media-app-apis.jar/
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "media-app-apis.jar"]