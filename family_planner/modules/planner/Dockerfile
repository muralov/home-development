FROM arm32v6/openjdk:8-alpine

MAINTAINER Mano Inc.

RUN mkdir /app
WORKDIR /app
COPY build/libs/planner-0.0.0.jar /app
VOLUME /app

EXPOSE 8081

CMD java -jar planner-0.0.0.jar
