<h1> Meals Planner App </h1>
<p> The following sections describe how to start the app with docker-compose and in development mode.</p

<p>
<h3> Start the app with docker-compose</h3>

This section describes how to start the all micro services with docker-compose

1. Create "meals-image" and "planner-image" images in the family_planner folder w/ the following commands:
    - docker build -t meals-image:1.0 -f modules/meals/Dockerfile .
    - docker build -t planner-image:1.0 -f modules/planner/Dockerfile .

2. Create a folder $HOME/data/postgres for the volume creation used docker compose file.

3. run "docker-compose up" in the root project folder

4. Start the frontend with "npm start"

Note: To stop all containers at once run "docker-compose down" command

</p>

<p>
<h3>Starting the app for development</h3>

1. Leave meals-db and planner-db services by deleting services meals-service and planner-service from docker-compose file.

2. Create a "food" database in meals-db service (container) with the following:
    - Get into the container with "docker exec -i -t {meals-db container id} bash"
    - Run "createdb -p 5432 -h localhost -e food -U postgres -w postgres" in the container   
    
3. Perform the steps of previous section
 
4. Change property "spring.datasource.url=jdbc:postgresql://localhost:5432/food" in the file modules/meals/src/main/resources/application.properties

5. Change mongoClient() method in the class MongoConnection to intialize new MongoClient("localhost")

6. Start meals-service and planner-service microservices with IDE you are programming with. 
</p>

<p>
<h3>Building images with Dockerfile</h3>

Steps to build an image and start the container for meals module:

1. Navigate to family_planner folder (root project folder)

2. run "docker image build -t meals-image:1.0 -f modules/meals/Dockerfile ." command


Steps to build an image and start the container for planner module:

1. Navigate to family_planner folder (root project folder)

2. run "docker image build -t planner-image:1.0 -f modules/planner/Dockerfile ." command
</p>




<p>
<h3>To see the REST API documentation with Swagger:</h3>

1. Use http://localhost:8080/swagger-ui.html to see the REST APIs of meals service

2. Use http://localhost:8081/swagger-ui.html to see the REST APIs of planner service
</p> 
