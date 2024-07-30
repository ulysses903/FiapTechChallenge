FROM openjdk:21

WORKDIR /app

COPY ./application/target/application-0.0.1-SNAPSHOT.jar /app/api-fiap-tech-challenge.jar

EXPOSE 8080

CMD ["java", "-jar", "api-fiap-tech-challenge.jar"]
