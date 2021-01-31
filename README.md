# xmen-dna-analyzer


# Requirements:

- Java 11
- Docker
- Docker-comppose
- Maven 3.x
- Lombok library (www.projectlombok.org) (only if you want to import the maven project into your favorite IDE)
- Mongo
# Documentation
  Swagger Endpoint : http://localhost:8080/dna.analyzer/v2/api-docs
# Coverage Information
  To manage coverage was through Jacoco, the final coverage it over 90%
  
# Jmeter Script
  Go to \adn-sentinel\Jmeter-XmenDNAAnalyzer.jmx
  
# Spring Profiles
- Local: To execute running locally.
- Docker: To execute as docker containers.

# Installation:

Goto to ../xmen-dna-analyzer/adn-sentinel directory

1. Run mvn verify Command
```
mvn clean verify 
```
2. Create Docket Network
```
$ docker network create --attachable -d bridge dna-analyzer
```
3. Run Mongo
```
$ docker run --name mongo -p 27017:27017 --network=dna-analyzer mongo
```
4. Run docker build

```
$ docker build -t mutant-analyser:v1 . && docker run -p 8080:8080 --network=dna-analyzer -e SPRING_PROFILES_ACTIVE=docker mutant-analyser:v1
```


# X-Men APi 

HealthCheck Resource

```
curl --location --request GET 'http://localhost:8080/dna.analyzer/actuator/health'
```

Mutant Dna Analyzer

```
curl --location --request GET 'localhost:8080/dna.analyzer/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}'
```

Mutant Dna Stats
```
curl --location --request GET 'http://localhost:8080/dna.analyzer/stats'
```

