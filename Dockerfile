FROM openjdk:18-jdk-slim as build
WORKDIR /app
COPY . /app/
RUN ["./gradlew", "build", "--no-daemon"]

FROM openjdk:18-jdk-slim
WORKDIR /run
COPY --from=build /app/build/libs/*.jar /run/
CMD ["java", "-jar", "/run/hazelcast-demo-0.0.1-SNAPSHOT.jar"]