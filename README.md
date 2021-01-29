# xmen-dna-analyzer


# Requirements:

Java 11
Docker
Docker-comppose
Maven 3.x
Lombok library (www.projectlombok.org) (only if you want to import the maven project into your favorite IDE)
MongoBD

# Installation:

Goto to ../xmen-dna-analyzer/adn-sentinel directory

1. Run mvn verify Command
```
mvn clean verify 
```
2. Run Mongo
```
$ docker run -p 27017:27017 mongo
```

3. Run docker build

```
$ docker build -t mutant-analyser:v1 . && docker run -p 8080:8080 mutant-analyser:v1 
```


# X-Men APi 

Mutant Dna Analyzer

```
curl --location --request GET 'localhost:8080/dna.analyzer/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}'
```

Mutant Dna Stats

