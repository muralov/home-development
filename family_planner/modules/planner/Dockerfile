FROM java:8
MAINTAINER Mano Inc.
ENV REFRESHED_AT 2018-05-10

RUN mkdir /app
WORKDIR /app
COPY build/libs/planner-0.0.0.jar /app
VOLUME /app

EXPOSE 8081

CMD java -jar planner-0.0.0.jar