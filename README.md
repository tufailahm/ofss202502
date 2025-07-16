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


