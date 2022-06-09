# PhotoSession_Reservation_App_Spring

## Project purpose
This is my final project (on Java Developer Course), which is a web application where clients can reserve photography sessions and photographer can manage all photo sessions.

## Design assumption
Photographer can handle only one photo session per day. Therefore, date must be unique in the database and client can't reserve already reserved date. The project is only a backend app.

## Used Frameworks, databases, libraries and web container
Pom.xml file with its dependencies says more than thousand words :) Briefly:
- frameworks: Spring Boot, Spring Data JPA, Spring Security, Hibrenate, JUnit,
- libraries: Lombok, Google Truth (used in unit tests - assertions), 
- databases: MySQL, h2 (h2 only for tests purposing),
- web container: Apache Tomcat.

## Basic functionalities
<ol>
<li>USER/ADMIN (photographer)
  <ol>
  <li>creating deafult admin - for now it's a method used in GET to create default admin (endpoint: /admin/create) - admin must be unique (only one user in database with role "ADMIN" is allowed).
    </li>
  <li>login - admin credentials:<br>
    - username: 'admin'<br>
    - password: 'admin1234'
    </li>
  <li>views<br>
    On the homepage user (admin/photographer) can select one of 5 available links, that will direct him/her into 5 different views:
    <ul>
    <li>Future Photo Sessions - table with all not completed, future photo sessions reserved by all clients sorted by dates,</li>
    <li>Completed Photo Sessions - table with all completed photo sessions reserved by all clients sorted by dates,</li>
    <li>All Photo Sessions - table with all photo sessions reserved by all clients sorted by dates with additional action in every row to mark particular           photo session as completed,</li>
    <li>All Clients - table with all clients,</li>
    <li>Logout - it will logout the user and redirect to login page</li>
      </ul>
     </li>
   </ol>
<li>USER/CLIENT
  <ol>
    <li>login - for already registered users/clients</li>
    <li>register - for new users/clients - jsp view with form that use POST method to add user/client to the database</li>
    <li>views<br>
     On the homepage user/client can select one of 4 available links, that will direct him/her into 5 different views:
    <ul>
    <li>Future Photo Sessions - table with all not completed, future photo sessions reserved by particular(logged) client sorted by dates,</li>
    <li>Completed Photo Sessions - table with all completed photo sessions reserved by particular(logged) client sorted by dates,</li>
    <li>All Photo Sessions - table with all photo sessions reserved by particular(logged) client sorted by dates</li>
    <li>Logout - it will logout the user and redirect to login page</li>
    </ul>
    </li>
  </ol>
</ol>

## Available endpoints and HTTP methods:
The endpoint that I recommend to start with is ```http://localhost:8080/login``` and then all pages/views has a navigation links, so you don't really have to know all of the exact endpoints. <br>
|HTTP Method	  |URL	                               |Expected action|
|---------------|----------------------------------------|----------------|
|GET	          |```http://localhost:8080/admin/create```|Default admin will be created|
|GET	          |```http://localhost:8080/login```	     |Redirect to jsp view with form to login with use of Spring Security|
|POST	          |```http://localhost:8080/login```	     |Method created and used automatically by Spring Security - user authentication|
|GET	          |```http://localhost:8080/logout```	     |Redirect to jsp view with form to logout with use of Spring Security|
|POST	          |```http://localhost:8080/logout```	     |Method created and used automatically by Spring Security - user logout process|
|GET	          |```http://localhost:8080/admin/all-clients```	     |List of all clients (users with role "CLIENT) will be created based on database and showed as a table in jsp view ```/admin/allClientsView```|
|GET	          |```http://localhost:8080/admin/sess-complete?id={requestParam}```|(Avbl for user with role "ADMIN") Particular photo session with id={requestParam} will be marked as completed=true in database and then user will be redirected to ```http://localhost:8080/photo-sess/all```|
|GET	          |```http://localhost:8080/client/create```|Redirect to jsp view ```/client/form-newClient``` with form to register a new user/client|
|POST	          |```http://localhost:8080/client/create```|New client/user will be added to the database. Redirect to login page to authenticate a new user/client.|
|GET	          |```http://localhost:8080/client/session-add```	     |Redirect to jsp view ```/client/form-newPhotoSession``` with form to reserve a photo session|
|POST	          |```http://localhost:8080/client/session-add```	     |New photo session will be added to the database for particular (logged) client. Redirect to ```http://localhost:8080/homepage```|
|GET	          |```http://localhost:8080/photo-sess/all```|List of all photo sessions will be created based on database and depending on logged user (diffrent for user with role "ADMIN" and different for user with role "CLIENT" - client will see only his/her photo sessiosn) and showed as a table in jsp view ```/user/allPhotoSessView```|




