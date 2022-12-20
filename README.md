# Backend I Class
Here you will find all the exercises that have been completed for the subject [BackEnd I]( ) under the Certified Tech Developer Program of Digital House.

# Classes
- Introduction to the backEnd I subject 
   - [Class 1](https://github.com/Pavelezl/Backend-CodingExercises/files/10147380/Clase.1.Ejercicio.con.el.profe.1.1.pdf): Make a list of people, add them to a group and proceed with the necessary methods. 
   - [Class 2](https://github.com/Pavelezl/Backend-CodingExercises/files/10147380/Clase.1.Ejercicio.con.el.profe.1.1.pdf): Continuing with the previous exercise, let's add some tests to test our code. We create a class for test, add the tests and test them until the result is positive. We use Unit Testing with JUnit. 
   
- Design Patterns In Java: 
   - [Class 3](https://github.com/Pavelezl/Backend-CodingExercises/files/10148738/Ejercicio_Profesor_Clase_2.docx.1.pdf): Template Method Pattern:

- Logging with Log4J: 
   - [Class 10](https://github.com/Pavelezl/Backend-CodingExercises/files/10170873/Ejercicio.con.el.profesor.pdf): We were asked to create an application that calculates the average, maximum and minimum values in a list of integers. Then, we must create a main class, where we create a list for each of the items and check that the logs exist.

- Database access, JDBC ,H2 Database: 
   - [Class 11](https://github.com/Pavelezl/Backend-CodingExercises/files/10180556/Class.11.-.1.pdf): Create an application that has access to a table of animals.


# Classwork
- Unit Testing with JUnit
   - [Classwork 1](https://github.com/Pavelezl/Backend-CodingExercises/files/10147391/Clas_1_Ejercicio_para_mesa_de_trabajo.pdf): Calculating the area of a geometric figure and applying the necessary tests.

- Design Patterns In Java: 
   - [Class 3](https://github.com/Pavelezl/Backend-CodingExercises/files/10148738/Ejercicio_Profesor_Clase_2.docx.1.pdf): Template Method Pattern: 
   
- Logging with Log4J: 
   - [Class 10](https://github.com/Pavelezl/Backend-CodingExercises/files/10170873/Ejercicio.con.el.profesor.pdf): Continuing with the previous exercise done in class 10. We were asked to create an application that calculates the average, maximum and minimum values in a list of integers. Then, we must create a main class, where we create a list for each of the items and check that the logs exist

- Database access, JDBC ,H2 Database: 
   - [Class 11](https://github.com/Pavelezl/Backend-CodingExercises/files/10180564/Class.11.-.2.pdf): We were asked to individually create a figure table where the types of figures are stored
   
# Proyecto integrador
Appointment booking system for a dental clinic. Project done for the Backend I subject, part of the Certified Tech Developer course taken at Digital House.

We want to implement a system to manage the appointment booking for a dental clinic. It must meet the following requirements: Dentist data management: list, add, modify and delete dentists. Register dentists' last name, first name and registration number. Patient data management: list, add, modify and delete patients. For each patient: name, surname, address, ID number and date of discharge are stored. Register appointment: it must be possible to assign a patient an appointment with a dentist at a certain date and time. Login: validate entry to the system by means of a login with username and password. Any logged-in user (ROLE_USER) must be allowed to register an appointment, but only those who have an administration role (ROLE_ADMIN) must be able to manage dentists and patients. A user can have only one role and they will be entered directly into the database.

- Technical Requirements
   - The application must be developed in layers:

      - Business entity layer: these are the Java classes of our business modeled through the object-oriented paradigm.
      - Data access layer (Repository): these are the classes that will be in charge of accessing the database.
      - Data layer (database): it is the database of our system modeled through an entity-relationship model. We will use the H2 base for its practicality.
      - Business layer: these are the service classes that are responsible for decoupling data access from the view.
      - Presentation layer: these are the web screens that we will have to develop using the Spring Boot MVC framework with the controllers and one of these two options: HTML+JavaScript or React for the view.
      - It is important to perform exception handling by logging any exception that may be generated and performing unit tests to ensure the quality of the developments.

=> Next step: Turn it into an appointment booking software like https://calendly.com/

