FROM arm32v6/openjdk:8-alpine

MAINTAINER Mano Inc.

RUN mkdir /app
WORKDIR /app
COPY build/libs/meals-0.0.0.jar /app
VOLUME /app

EXPOSE 8080

#the following command waits for the postgres server to start and creats "food" database on postgres container
CMD java -jar meals-0.0.0.jar
