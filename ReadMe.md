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
To build the application
```sh
mvn clean install
````

To run the application, you will need to setup tomcat deploy as a Maven Run item. Run->Run Config -> Maven 
![alt text] (https://github.com/lielar/dva/raw/master/run_config.png "Maven Run Config")


# Test cases
Run the test cases in Eclipse.

# Pages to view
1. claims.html - lists all the claims.
2. users.html - lists all the users and their respective claims. Uses a REST endpoint.


