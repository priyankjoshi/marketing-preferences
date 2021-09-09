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

 ## Sample Request from PostMan
    1. Few users are default created by the spring boot app with user id 1 and 2
    2. Sample Post request to create new post for user 1
    ```
    curl --request POST 'localhost:8080/api/v1/user/2/post' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "title":"First Post",
        "description" :" This is the  First post Description"
      }'
    ```
