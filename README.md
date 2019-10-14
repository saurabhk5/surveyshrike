# SurveyShrike Application

This application helps users to create surveys and get users feedback for analysis purposes.

### Prerequisites

	Git
	Java 1.8
	Maven 3.x.x
	Postgres Database
	Spring Tool Suite

## Clonning the repository
	
	git clone https://github.com/saurabhk5/surveyshrike.git
	cd surveyshrike

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