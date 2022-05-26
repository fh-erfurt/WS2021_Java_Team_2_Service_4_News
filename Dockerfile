FROM maven:3.8.5-openjdk-18 AS builder

WORKDIR /app

COPY . .

RUN mvn -f /app/pom.xml clean package

FROM openjdk:18-jdk-alpine3.15

COPY --from=builder /app/news-service/target/news-service-1.0.0.0-SNAPSHOT.jar /usr/local/lib/news-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/usr/local/lib/news-service.jar"]
