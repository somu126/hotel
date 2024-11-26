FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/Boking-0.0.1-SNAPSHOT.jar Boking.jar
EXPOSE 4040
ENTRYPOINT ["java","-jar","Boking.jar"]
