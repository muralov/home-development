FROM java:8
MAINTAINER Mano Inc.
CMD ["mkdir", "app"]
COPY . /app
WORKDIR /app
CMD ["./gradlew", "build", "-x", "test"]
CMD ["java", "-jar", "modules/meals/build/libs/meals-0.0.0.jar"]
EXPOSE 8080