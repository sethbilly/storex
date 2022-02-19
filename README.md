# Storex
Microservice to handle a simple stock exchange system.
## Getting Started
These instructions will get you a copy of the project up and running
on your local machine for development, testing and even to production.

### Prerequisites
You need to install the following and add to system paths.
```
java11
maven
postgresql
docker
```
### Running
Clone or download repository and run maven in the root of the directory. A step by step
series of actions that tell you how to get project running. 
#### Running the microservice with maven
```
project_root_directory > mvn clean package
```
Compiles and builds classes and resources into jar file. A target folder 
is generated containing the build.
##### windows platform
```
project_root_directory > java -jar \target\storex-1.0.jar
```
##### unix platform
```
project_root_directory > java -jar /target/storex-1.0.jar
```
This will spin an embedded tomcat server and the application
can be accessed on localhost and port set in the application.properties
file in the source directory of the project
```
http://localhost:8080
```
#### Running application with docker container
```
project_root_directory > mvn clean package
```
Build the docker image 
```
project_root_directory> docker build -t storex .
```
Once the docker image has been built, you can run it using the command
```
project_root_directory> docker run -p 8080:8080 storex
```
```$xslt
project_root_directory> docker-compose up 
```
## API Endpoints
METHOD     |     URL                                       | functionality                              |
-----------|-----------------------------------------------|:-------------------------------------------|
  GET      | http://localhost:8080/api/stocks              | list all stocks optional pagination        |
  GET      | http://localhost:8080/api/stocks/{id}         | get single stock detail                    |
  POST     | http://localhost:8080/api/stocks              | create a new stock                         |
  PATCH    | http://localhost:8080/api/stocks/{id}         | update stock current price                 |
  DELETE   | http://localhost:8080/api/stocks/{id}         | delete single stock                        |


## Deployment
The build in the target folder can be executed on cloud or server hosting platform.

## Built With
- SpringBoot
- Maven
- Java 11
- Docker (Docker Compose)

## Versioning
Version 1