FROM java:8
MAINTAINER Mano Inc.
ENV REFRESHED_AT 2017-10-09
COPY . /app
WORKDIR /app
RUN ./gradlew build -x test
EXPOSE 8081
CMD ["java", "-jar", "modules/planner/build/libs/planner-0.0.0.jar"]