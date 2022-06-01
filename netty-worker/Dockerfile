FROM maven:3-openjdk-8 AS build
WORKDIR /app
COPY src src
COPY pom.xml pom.xml
RUN mvn package

FROM openjdk:8-jre-alpine
RUN mkdir /app
COPY --from=build /app/target/netty-worker-1.0-SNAPSHOT-jar-with-dependencies.jar /app
ENV WORKER_SERVICE_PORT=8080
CMD ["java","-jar", "/app/netty-worker-1.0-SNAPSHOT-jar-with-dependencies.jar"]