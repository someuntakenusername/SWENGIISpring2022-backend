FROM maven:3.8.4

WORKDIR /userGuide

COPY /src .

COPY pom.xml .

RUN mvn install -DskipTests

FROM openjdk:16

COPY target/userGuide-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]