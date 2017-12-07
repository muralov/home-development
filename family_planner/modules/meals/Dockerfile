FROM java:8
MAINTAINER Mano Inc.
ENV REFRESHED_AT 2017-12-7
COPY . /app
WORKDIR /app
RUN ./gradlew build -x test
CMD ["java", "-jar", "modules/meals/build/libs/meals-0.0.0.jar"]
EXPOSE 8080