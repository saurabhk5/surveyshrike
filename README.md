# SurveyShrike Application

This application helps users to create surveys and get users feedback for analysis purposes.

![alt-text](https://github.com/saurabhk5/surveyshrike/blob/develop/documents/surveyshrike-architure-diagram.JPG)

### Prerequisites

	Git
	Java 1.8
	Maven 3.x.x
	Postgres Database
	Spring Tool Suite

## Clonning the repository
	
	git clone https://github.com/saurabhk5/surveyshrike.git
	cd surveyshrike
	
## Setting up database

![alt-text](https://github.com/saurabhk5/surveyshrike/blob/develop/documents/surveyshrike-er-diagram.jpg)

	Create schema and table using script:
		https://github.com/saurabhk5/surveyshrike/tree/develop/scripts/postgres/create-schema-and-table.sql
	
	Change database setting in file:
		https://github.com/saurabhk5/surveyshrike/tree/develop/src/main/resources/application.properties
	

## Starting your work

	Update your local repository

		git checkout develop
		git pull

### Running the application

	Import the project in STS as a maven project.
	Run
		mvn clean install 
	
	Start this project as a springboot application.
	Open any browser and enter http://localhost:8080/swagger-ui.html

## Running the tests

	Go to the folder where project is pulled.
	Open CMD in that folder path and run mvn clean install.
	This will execute all JUNITS test cases.


## Deployment

	To deploy this application on docker, get your account onboarded to docker.
	Create an image with Java as base image and push the image to DTR.
	Pull the image from DTR and create a stack with any number of containers.

## Who maintains and contributes to project
	
	Saurabh Kumar
