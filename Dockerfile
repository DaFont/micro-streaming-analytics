FROM maven:3.5-jdk-8 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/src/app/target/micro-streaming-analytics-0.1.0-SNAPSHOT.jar /usr/app/micro-streaming-analytics-0.1.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/micro-streaming-analytics-0.1.0-SNAPSHOT.jar"]