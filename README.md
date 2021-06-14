**# NPS  Customer Satisfaction Survey**
This project is a backend project which inculudes Restfull Web Services for a Survey Application and developed with Spring Boot.
Application consists of create survey, fill survey, and listing answers endpoints.

Project was developed with Java language by using Eclipse IDE and Spring Boot Initializer. (https://start.spring.io/)

**Project Urls:**

 * http://localhost:8080/ for api testing.
 * http://localhost:8080/h2-console  for db interface,
 * http://localhost:8080/swagger-ui.html  for swagger interface.
  

**Project Details:**

This project can be import by any IDE. When configuration project select as Maven Project and run project as Spring Boot App.
This project topology consists of these packages;

	* Controller
	* Entity
	* Repository
	* Service
	* Config

**Database Details:**
This project is using H2 Database to store data. After project run, database can be accessed from this url like http://localhost:8080/h2-console/ .
Database setting can be changed from /survey/src/main/resources/application.properties
There are two tables which are named like ANSWER AND SURVEY.

<img src="https://user-images.githubusercontent.com/60251724/121952019-5b78d000-cd64-11eb-9581-53d67726c5c5.png" width="600" height="300">
<img src="https://user-images.githubusercontent.com/60251724/121954490-78fb6900-cd67-11eb-8096-4b8b93609c49.png" width="600" height="300">


**API Details:**


<img src="https://user-images.githubusercontent.com/60251724/121955092-2ec6b780-cd68-11eb-8310-41e8d1037f88.png" width="700" height="400">

**Application Endpoints:**

		1. Create Survey

<img width="570" alt="CreateSurvey" src="https://user-images.githubusercontent.com/60251724/121955453-a8f73c00-cd68-11eb-84d6-a0cc9ac127a0.PNG">
      ** Case: Create Survey with NPS Score**

<img width="525" alt="CreateSurveyWithNpmScore" src="https://user-images.githubusercontent.com/60251724/121955577-ccba8200-cd68-11eb-9241-05e8be79dc8c.PNG">
      ** Case: Create Survey with Existed Topic**

<img width="509" alt="CreateSurveyWithExistedTopic" src="https://user-images.githubusercontent.com/60251724/121955589-d17f3600-cd68-11eb-9d89-787c55358fef.PNG">

		2.	Submit Survey 

<img width="550" alt="submitAnswer" src="https://user-images.githubusercontent.com/60251724/121956812-3d15d300-cd6a-11eb-8949-abdd452003e4.PNG">
		3. List Survey Answers

<img width="483" alt="ListAnswersByTopicSuccess" src="https://user-images.githubusercontent.com/60251724/121957575-4489ac00-cd6b-11eb-9d07-00788ff8ddb0.PNG">

<img width="417" alt="ListAnswersByTopicFailed" src="https://user-images.githubusercontent.com/60251724/121957585-481d3300-cd6b-11eb-9ec4-763e209482ff.PNG">


		4. List Survey Topics With NPS
		
<img width="523" alt="xxx" src="https://user-images.githubusercontent.com/60251724/121957391-ff657a00-cd6a-11eb-9f8a-4ebf9c96a17b.PNG">






