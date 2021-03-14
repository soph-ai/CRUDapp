# First Project: CRUD app- Mr Meeseeks Box 

My first project was to build a CRUD app (Create, Read, Update and Delete). This incorporated many different technologies and methodologies we have learnt, including full data stack development, interaction with a database via H2 console and a fully functioning front-end built using HTML, CSS and JavaScript. 

## Contents 
1. Brief 
2. My Approach 
3. Kanban board 
4. Tech Stack 
5. Testing 
6. Front-end 
7. Future Improvements 
8. Author and Acknowledgements 

## Resources 
My [Kanban board](https://my-crud-jira-board.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=APP&atlOrigin=eyJpIjoiMGY4M2VhOWJhYjY1NDEyOGJlNjQ5ZjA3ZjRjN2Y0MTYiLCJwIjoiaiJ9)  
My [Presentation]()  
My [Front-End Git Repo](https://github.com/soph-ai/CRUDAppFE.git)  

## Brief 
The aim of this project is to create a CRUD application.  
  
This project will involve key concepts from the core training modules:

* Project Management
* Databases
* Java SE
* Spring Boot
* Front-End Development
* Automated Testing

## My Approach 
After some deliberating, I decided to do my porject as an application version of a Mr Meeseeks Box from Rick and Morty. This is one of my favourite TV series so I was really excited to get started! 

Mr Meeseeks' are creatures created to serve a singular purpose. Once they have served this purpose they expire/vanish. 

My app will allow the user to summon a Mr Meeseeks by activating a Mr Meeseeks box. *(Create).* This allows you to name him and assign him a task you want him to complete, recording also the date that the task was assigned. Mark the task as completed once Mr Meeseeks has fulfilled his purpose and he will then disappear/expire. (*Delete*).  

Although dedicated to the task initially assigned to him, Mr Meeseeks can be persuaded to shift his purpose- you can then ask him to complete a different task of your choosing. *(Update).* 

This app allows for full CRUD functionality, allowing you to create Mr Meeseeks, update his task/purpose, delete him when expired and view all the tasks you have assigned to Mr Meeseeks'. *(Read).*

## Kanban board 
Below is a screenshot of my Kanban board. I used Jira software to create my Agile Kanban board. Production works from left to right, so when tasks are completed they are placed in the right "Done" column.  
![image](https://user-images.githubusercontent.com/78798512/111064292-14501a00-84ab-11eb-86ec-ce232aac52c3.png)

My Kanban board consists of one epic (use case), user stories and tasks.  
An example of a user story is below.   
![image](https://user-images.githubusercontent.com/78798512/111064495-326a4a00-84ac-11eb-83fb-f00dbfff2297.png)

## Tech Stack 
The tech stack for this project is below:  

* Database: SQL Server (via a local H2 console) 
* Programming language: Java (using the Spring Boot Framework) 
* Front-end: HTML, CSS (design the website) and JavaScript (to interact with the DB) 
* Unit Tests: JUnit and Mockito
* Integration Tests: MockMVC and Selenium
* Version Control System: Git (and GitHub) 

## Testing 
Below is a screenshot of the controller integration test conducted using MockMVC. This is used to test the HTTP requests such as "/createMeeseeks" and tests the back-end of the app end-to-end.  
![image](https://user-images.githubusercontent.com/78798512/111064932-de149980-84ae-11eb-8198-d201b1bb3059.png)

Below is my service DB unit test using Mockito. This creates a mock repo which emulates how the real repo will work without also testing the repo. It allows us to skip over the DB interaction for testing purposes and test just a single "unit" of the program.  
![image](https://user-images.githubusercontent.com/78798512/111065111-f507bb80-84af-11eb-8514-de80d5cf3fa3.png)


