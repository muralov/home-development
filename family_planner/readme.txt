This file describes how to start meal planner app backend with the following steps:

1. run "docker-compose up" in the root project folder

2. create a "food" database in meals-db service (container) with the following:
   2.1. Get into the container with "docker exec -i -t {meals-db container id} bash"
   2.2. Run "createdb -p 5432 -h localhost -e food -U postgres -W postgres" in the container

3. run "docker-compose down" and "docker-compose up" restart the containers

4. Start the frontend with "npm start"