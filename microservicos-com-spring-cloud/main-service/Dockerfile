FROM maven:3.9.6-amazoncorretto-21-debian AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM amazoncorretto:21

COPY --from=build /app/target/MainService-0.0.1-SNAPSHOT.jar /usr/app/app.jar

WORKDIR /APP

EXPOSE 8888

CMD ["java", "-jar", "app.jar"]