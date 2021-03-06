# First Project: CRUD app- Mr Meeseeks Box 

My first project was to build a CRUD app (Create, Read, Update and Delete). This incorporated many different technologies and methodologies we have learnt, including full data stack development, interaction with a database via H2 console and a fully functioning front-end built using HTML, CSS and JavaScript. 

## Contents 
1. Brief 
2. My Approach 
3. Kanban board 
4. Tech Stack 
5. Testing 
6. Front-End 
7. Future Improvements 
8. Author and Acknowledgements 

## Resources 
My [Kanban board](https://my-crud-jira-board.atlassian.net/secure/RapidBoard.jspa?rapidView=1&projectKey=APP&atlOrigin=eyJpIjoiMGY4M2VhOWJhYjY1NDEyOGJlNjQ5ZjA3ZjRjN2Y0MTYiLCJwIjoiaiJ9)  
My [Presentation](https://docs.google.com/presentation/d/1XlOyeqpEbgSxUrcK8uik5MADct4HSA3E3bxBu4NHFJY/edit#slide=id.gcb9a0b074_1_103)  
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
After some deliberating, I decided to build my project as an application version of a Mr Meeseeks Box from Rick and Morty. This is one of my favourite TV series so I was really excited to get started! 

Mr Meeseeks' are creatures created to serve a singular purpose. Once they have served this purpose they expire/vanish. 

My app will allow the user to summon a Mr Meeseeks by activating a Mr Meeseeks box. *(Create).* This allows the user to name him and assign him a task the user wants him to complete, recording also the date that the task was assigned. The user can mark the task as completed once Mr Meeseeks has fulfilled his purpose and he will then disappear/expire. (*Delete*).  

Although dedicated to the task initially assigned to him, Mr Meeseeks can be persuaded to shift his purpose- the user can then ask him to complete a different task of their choosing. *(Update).* 

This app allows for full CRUD functionality, allowing the user to create Mr Meeseeks, update his task/purpose, delete him when expired and view all the tasks the user has assigned to Mr Meeseeks'. *(Read).*

## Kanban board 
Below is a screenshot of my Kanban board. I used Jira software to create my Agile Kanban board. Production works from left to right, so when tasks are completed they are placed in the right "Done" column.  
![image](https://user-images.githubusercontent.com/78798512/111064292-14501a00-84ab-11eb-86ec-ce232aac52c3.png)

My Kanban board consists of one epic (use case), user stories and tasks.  
An example of a user story is below.   
![image](https://user-images.githubusercontent.com/78798512/111064495-326a4a00-84ac-11eb-83fb-f00dbfff2297.png)

## Tech Stack 
The tech stack for this project is below:  

* Database: SQL Server and a local H2 console (for testing)  
* Programming language: Java (using the Spring Boot Framework) 
* Front-End: HTML, CSS (design the website) and JavaScript (to interact with the DB) 
* Unit Tests: JUnit and Mockito
* Integration Tests: MockMVC and Selenium
* Version Control System: Git (and GitHub) 

## Testing 
Below is a screenshot of the controller integration test conducted using MockMVC. This is used to test the HTTP requests such as "/createMeeseeks" and tests the back-end of the app end-to-end.  
![image](https://user-images.githubusercontent.com/78798512/111064932-de149980-84ae-11eb-8198-d201b1bb3059.png)

Below is my service DB unit test using Mockito. This creates a mock repo which emulates how the real repo will work without also testing the repo. It allows the DB interaction to be skipped over for testing purposes and tests just a single "unit" of the program.  
![image](https://user-images.githubusercontent.com/78798512/111065111-f507bb80-84af-11eb-8514-de80d5cf3fa3.png)

## Front-End 
Below is a screenshot of my home page, from which you can navigate to the app page. I inlcuded a description of what a Mr Meeseeks is for those who have not watched Rick and Morty, so they should still be able to use and understand my app.  

![image](https://user-images.githubusercontent.com/78798512/111065523-22edff80-84b2-11eb-8452-37b6e10ba235.png)

Here is the main screen for my app:  
![image](https://user-images.githubusercontent.com/78798512/111065543-44e78200-84b2-11eb-81d7-c0535eb42673.png)  
After activating some Meeseeks', they will appear at the bottom of the screen: 
![image](https://user-images.githubusercontent.com/78798512/111065606-84ae6980-84b2-11eb-9e4a-826f400e759b.png)
After clicking on the "edit" button, this screen (modal) appears, where a user can update the purpose (or name or date activated) of their activated Mr Meeseeks.  
![image](https://user-images.githubusercontent.com/78798512/111065726-161ddb80-84b3-11eb-9158-de781511c428.png)

## Automated Testing 
Below is a screenshot of the two tests I managed to complete. This was a HUGE struggle as my server was being extremely difficult but with mine and Jordan's perserverance we managed to find a way around it using the thread.sleep method instead! I ran my test on port 8080 and I have the Front-End still running on the live server (5500) pointing at 8080.  
![image](https://user-images.githubusercontent.com/78798512/111073917-9efb3e00-84d8-11eb-8c1a-9c8ae76776c3.png)



## Future Improvements 
I had a lot of ideas for this project to begin with and I quickly realised most of them would not be possible in the timeframe available!  

These ideas included: 

* Having the activate Meeseeks button on top of the Meeseeks box image. (Although attempted, I haven't quite achieved it yet!) 
* A button that when clicked says "Hi I'm Mr Meeseeks! Look at me!" Which is Mr Meeseeks' catchphrase. 
* The longer Mr Meeseeks is alive, the more blotched and "degraded" he looks in appearance. I really wanted to try and incorporate this somehow, so the longer a task was left uncompleted, the more blotchy it appeared so that it was obvious to the user which tasks had been there the longest. 
* Add a second table to the DB- possibly for a second Mr Meeseeks box that would be for different types of tasks to the first one. 

## Author and Acknowledgements 
I would like to acknowledge the QA trainers, with special thanks to Jordan. 

Project by Sophie Havell 

