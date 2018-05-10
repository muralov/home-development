FROM openjdk:9-jre-slim
MAINTAINER Mano Inc.
ENV REFRESHED_AT 2018-05-10

RUN mkdir /app
WORKDIR /app
COPY build/libs/meals-0.0.0.jar /app
VOLUME /app

EXPOSE 8080

#the following command waits for the postgres server to start and creats "food" database on postgres container
CMD java -jar meals-0.0.0.jar