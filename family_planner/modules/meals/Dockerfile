FROM java:8
MAINTAINER Mano Inc.
ENV REFRESHED_AT 2017-12-7
COPY . /app
WORKDIR /app

# Add the PostgreSQL PGP key to verify their Debian packages.
# It should be the same key as https://www.postgresql.org/media/keys/ACCC4CF8.asc
RUN apt-key adv --keyserver keyserver.ubuntu.com --recv-keys B97B0AFCAA1A47F044F244A07FCC7D46ACCC4CF8

# Add PostgreSQL's repository. It contains the most recent stable release of PostgreSQL Client.
RUN echo "deb http://apt.postgresql.org/pub/repos/apt/ precise-pgdg main" > /etc/apt/sources.list.d/pgdg.list

# Install PostgreSQL Client to run commands with remote server
#  There are some warnings (in red) that show up during the build. You can hide
RUN apt-get update && apt-get -y -q install postgresql-client
RUN apt-get -y install expect

RUN ./gradlew build -x test

EXPOSE 8080

#the following command waits for the postgres server to start and creats "food" database on postgres container
CMD chmod u+x wait-for-it.sh && chmod u+x modules/meals/enter-pass.exp \
 && ./wait-for-it.sh meals-db:5432 -- expect modules/meals/enter-pass.exp \
 && java -jar modules/meals/build/libs/meals-0.0.0.jar