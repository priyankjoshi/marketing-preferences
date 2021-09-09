# marketing-preferences
Spring Boot application to save the marketing preference of a user like Post

## How to run it
 * Pre-requisite (for first time run only) <br>
  Create a folder for mysql volume mount <br>
  `mkdir -p ~/data/mysql8`

 * Build<br>
   `./gradlew clean build`

 * Run via Docker Compose <br>
   `docker-compose up`
   
   
 ## Note
 * This application contains the docker-compose file which does 2 task
    1. Run the mysql on a docker container
    2. Run the spring boot app on docker container
    3. Link the above 2 app use docker network
