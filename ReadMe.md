# Introduction
This is my attempt for the DVA RFQ - DVA ICTSB RFQ-004.

# Overview
This application uses
* Java
* Maven for building
* JDBI for DB access
* Hypersonic DB. 
* Spring for dependency injection
* FreeMarker Java Template Engine
* JQuery to manipulate DOM from results of a endpoint REST execution
* Bootstrap CSS


# Instructions
To build the application,
```sh
mvn clean install
````

To run the application
```sh
mvn tomcat7::deploy
```
# Pages to view
1. claims.html - lists all the claims.
2. users.html - lists all the users and their respective claims. Uses a REST endpoint.
