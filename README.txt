Name: Rohan Doulakar
Assignment (3) - Q(1): Database Interaction with PostgreSQL and Application Programming

Link to Video: https://youtu.be/_gsSCOTuwsk

In the folder Database Creation Scripts it contains the files ddl.sql to create the table as per the schema and
dml.sql for the insertion of the initial data set.

In the Main.java the main function establishes a connection with the database and an object database is created where 
the four application functions are called with the appropriate parameters. The four functions getAllStudents(),
addStudent(first_name, last_name, email, enrollment_date), updateStudentEmail(student_id, new_email) and
deleteStudent(student_id) are in the Main.java file. 

To compile the program: javac Main.java

To run the application: First make sure a database is created and initialized on pgAdmin.
Since the project uses Maven to load the org.postgresql dependency we need an IDE such as IntelliJ
where we need to right-click on Main.java and click Run 'Main.main()' and the effects will be visible on the database.