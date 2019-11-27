## About the repository

This repository contains the source code for a spring-boot microservices application implemented as part of the coding challenge.

## Problem statement

This application provides a service that given an origin city will return a list of itineraries, one based in the fewer number of connections and the second based in less time. The elements of this scenario are the following:

* mysql-db: A simple Mysql instance, used by data-service microservice to obtain the city data.
* config-server: Server used by the rest of the apps to obtain their properties. It listens on port 9000.
* eureka-server: It is a Spring boot application based on Spring Cloud Netflix EurekaServer acting as service registry, it is used by all the running microservices. The gateway server will use this registry to know if a microservice is alive. It listens on port 8761
* security-server: It is a Spring boot application that creates and checks a JWT token. Zuul will use this server to validate the user credentials every time it receives a request. It listens on port 8000
* api-gateway-server: It is a Spring boot application based on Spring Cloud Netflix Zuul. The main entry point for the infrastructure. It checks the user credentials, performs security access and redirects each request to the corresponding microservice. Also, it exposes a Swagger UI. It listens on port 8080
* city-data-server: It is a Spring boot application providing storage services for routes: retrieval, insertion, and deletion. It uses Mysql and spring-data-jpa to implement the repository layer. It listens on port 8081
* path-analyzer-server: It is a Spring boot application that exposes two endpoints to get the shortest and quickest route between two cities. All the business logic is here. It listens on port 8082


## Technology
The stack technology is the following:
* Java8
* Spring Boot 2.1.9
* Spring Cloud 2 (Greenwich.SR3)
* io.jsonwebtoken
* Mysql - latest version
* Docker - 19.03.4
    
### Libraries
* swagger2 (springfox)
* mysql-connector-java
    
### Spring Boot
The reason to choose Spring Boot is that Spring Boot provides a fast development experience using Spring. It configures many things out-of-the-box, saving a lot of time when starting a new project.

### Spring Cloud
Spring Cloud has been chosen because it´s the simple option to go if Spring Boot is used. The integration is seamless. It provides a config server, a discovery server, a gateway server, and fallback mechanisms.

### io.jsonwebtoken
One of the most popular libraries when handling JWT tokens. Hides the complexity of the tokens, and provides a fluent API.


### How to start

There are a few tools that must be installed on the computer prior to run and execute the challenge. These tools are Java, Maven, and Docker.

 1. Download / Clone the github repo.
 2. Maven over the root folder: "mvn clean package -DskipTests=true"
 3. Create the docker containers by executing these command in root folder of project:
    * docker-compose --build   
 4. Finally, execute the following command:
    * docker-compose up
    
In order to perform requests, the user must be authenticated. Use Postman, or your favorite tool, to perform a request to http://localhost:8001/auth . The body must be a JSON like this { "username": "admin", "password": "admin"} The response of this request will contain an Authorization header. From now on, use this header in every request you dispatch.
    
### Gateways


**Service**|**Method**|**EndPoint**
-----|-----|-----
city-data-server|GET|/city-api/routes
path-analyzer-server|GET|/path-analyzer/path/calculate/bytime?city={city}&amp;destinationCity={destinationCity}
path-analyzer-server|GET|/path-analyzer/path/calculate/byconnection?city={city}&amp;destinationCity={destinationCity}
