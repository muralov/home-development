<h1> Meals Planner App </h1>
<p> The following sections describe how to set up the app </p

<p>
1. Create a folder /home/django/data/postgres for the volume creation in docker compose file.

2. run "docker-compose up" in the root project folder

3. create a "food" database in meals-db service (container) with the following:
   2.1. Get into the container with "docker exec -i -t {meals-db container id} bash"
   2.2. Run "createdb -p 5432 -h localhost -e food -U postgres -w postgres" in the container

4. run "docker-compose down" and "docker-compose up" restart the containers

5. Start the frontend with "npm start"
</p>

<p>
Building images with Dockerfile

Steps to build an image and start the container for meals module:

1. Navigate to family_planner folder (root project folder)

2. run "docker image build -t meals-image:1.0 -f modules/meals/Dockerfile ." command


Steps to build an image and start the container for planner module:

1. Navigate to family_planner folder (root project folder)

2. run "docker image build -t planner-image:1.0 -f modules/planner/Dockerfile ." command
</p>

<p>
To see the REST API documentation with Swagger:

1. Use http://localhost:8080/swagger-ui.html to see the REST APIs of meals service

2. Use http://localhost:8081/swagger-ui.html to see the REST APIs of planner service
</p> 
