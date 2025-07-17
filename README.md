"# ofss202502" 
https://codeshare.io/tufail

Case Study

PPT


SELECT employee_id,
       hire_date,
       ADD_MONTHS(hire_date, 6) AS review,
       TRUNC(SYSDATE) - hire_date AS tenure
FROM employees
WHERE hire_date > ADD_MONTHS(TRUNC(SYSDATE), -240);


https://ouconnect.oracle.com/

Enter in user name: 98789336.user01 ... 98789336.user30
Enter in password: DbI6TkjZTJ (same for all users)


oracle
OU98789336

------------------------------------------------------

Use the ALTER TABLE statement to:
Add a new column
Modify an existing column definition
Define a default value for the new column
Drop a column
Rename a column
Change table to read-only status



DML
	- insert


	- delete
	- update


-------------------------------------



Views









