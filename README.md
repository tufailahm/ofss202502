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


select * from employees

select employee_id, first_name from employees;

select employee_id, first_name,salary from employees;

select employee_id, first_name,salary,job_id from employees;

select sysdate from dual;

select first_name,last_name,salary,commission_pct from employees;

---Calculate month salary for each employee
select first_name,last_name,salary,commission_pct, salary+salary*commission_pct from employees;
--solution later

--Annual Salary
select first_name,last_name,salary,commission_pct, (salary+salary*commission_pct)*12 from employees;


-----Column alias

select first_name,last_name,salary,commission_pct, (salary+salary*commission_pct)*12 AnnualSalary from employees;

select first_name,last_name,salary,commission_pct, (salary+salary*commission_pct)*12 "Annual Salary" from employees;

select first_name,last_name,salary,commission_pct, (salary+salary*commission_pct)*12 as "Annual Salary" from employees;

select first_name  || last_name from employees;

SELECT department_name || q'[ Department's Manager Id: ]'
       || manager_id 
       AS "Department and Manager" 
FROM departments;


---distinct

select distinct(hire_date) from employees;

select distinct(job_id) from employees;

---describe

describe employees;

-------------------2 minutes



---WHERE


SELECT employee_id, last_name, job_id, department_id
FROM   employees
WHERE  department_id = 90 ;


SELECT employee_id, last_name, job_id, department_id
FROM   employees
WHERE  Job_id = 'AD_VP';
--case problem

SELECT employee_id, last_name, job_id, department_id
FROM   employees
WHERE  first_name = 'David'

SELECT last_name 
FROM   employees
WHERE  hire_date = '07-JUN-02' ;

--RR format ??
SELECT last_name,hire_date ,salary
FROM   employees
WHERE  hire_date  between '01-JAN-02' and '31-Dec-02'
and salary > 10000

--IN
SELECT last_name,hire_date ,salary
FROM   employees
where employee_id in (100,101,102);

SELECT last_name,hire_date ,salary,department_id
FROM   employees
where department_id in (100,10,20);

---LIKE
SELECT	first_name
FROM 	employees
WHERE	first_name LIKE 'S%' ;

SELECT	first_name
FROM 	employees
WHERE	first_name LIKE '_a%' ;

SELECT	first_name
FROM 	employees
WHERE	first_name LIKE '%a' ;

-------------
SELECT	first_name
FROM 	employees where department_id is NULL


----GET ME ALL EMPLOYEES WHOSE salary is greater 12000 and not work in department_id 100 ,
--also his/her job ID should be IT_PROG
select * from employees;
select employee_id, first_name,department_id, job_id from employees
where salary > 12000 and department_id NOT in (100)
and job_id = 'IT_PROG'

update employees
set salary = 15000,
job_id = 'IT_PROG',
department_id = 10
where employee_id = 140;




---

SELECT last_name, department_id, salary
FROM   employees
WHERE  ( department_id = 60
OR     department_id = 80)
AND    salary > 10000;

-----


SELECT employee_id, last_name, salary, department_id
FROM   employees
WHERE  employee_id = &employee_num ;

-----
define sal = 12000;

SELECT employee_id, last_name, department_id
FROM   employees
WHERE  salary > &sal;

undefine sal = 12000;

------------------

SELECT employee_id, last_name, job_id, department_id
FROM   employees
WHERE  initcap(first_name) = 'David'


SELECT employee_id, last_name, job_id, department_id
FROM   employees
WHERE  lower(first_name) = 'david'

select LPAD(24000,10,'*') from dual;
    select LPAD(salary,10,'A') from employees;
select LPAD(first_name,10,'1') from employees;


-----------------
SELECT last_name, (SYSDATE-hire_date)/7 AS WEEKS
FROM   employees
WHERE  department_id = 90;


--- Print employee first name , hire date, expr (in years) 
select first_name, hire_date , round((sysdate-hire_date)/365) from employees;

select next_day(sysdate,'FRIDAY') from dual;



------


SELECT employee_id,
       hire_date,
       ADD_MONTHS(hire_date, 6) AS review,
       TRUNC(SYSDATE) - hire_date AS tenure
FROM employees
WHERE hire_date > ADD_MONTHS(TRUNC(SYSDATE), -240);



--------------------Conversion

select employee_id, email, phone_number,salary from employees;


select email+1 from employees

select to_number(email)+1 from employees



select email +to_char(1) from employees

create table abc
(  
sid varchar2(20),
marks varchar2(20)
)

insert into abc values('99','94')
insert into abc values('a','94')


select sid+marks from abc;

select to_number(sid)+marks from abc where sid = 'a'



-----------------


-- NVL  - converts NULL value to an actual value

select employee_id, first_name, salary , commission_pct,  (salary+ NVL(commission_pct,0)) from employees;

select employee_id, first_name, salary , commission_pct,  NVL(email,'no email')  from employees;
where email is null


-----

select first_name,last_name,salary,NVL(commission_pct,2), (salary+salary*NVL(commission_pct,2))*12 from employees;


----------------
---Those who are in department will not get salary bonus, else 5000 bonus should come

select first_name,last_name,salary,NVL2(department_id,salary,salary+5000) from employees
where department_id is null;
 
 
 select first_name,last_name,salary,NVL2(ccnumber,"No","Yes") from employees
where department_id is null;

 select first_name,last_name,salary,NVL2(ccnumber,0,5) from employees
where department_id is null;

 select first_name,last_name,salary,NVL2(cibilNumber,0,"Loan Cannot") from employees
where department_id is null;





SELECT first_name, LENGTH(first_name) AS expr1, 
       last_name,  LENGTH(last_name)  AS expr2,
       NULLIF(totalAmountDue,AmountPaid) AS Result
FROM   employees;

NULLIF--


update employees 
set salary = null
where employee_id = 100;

select employee_id,first_name,salary,commission_pct from employees where employee_id in (101, 100, 154);

--- salary is null + 5000
--- commission is null - sal+2000
--- sal +commission
--- commision+1

select * from employees;

SELECT employee_id, last_name, salary, commission_pct,
coalesce((salary+(commission_pct*salary)), salary+2000, 5000) as "New Salary" 
from employees where employee_id in (100, 101, 158);

SELECT employee_id, last_name, salary, commission_pct,
coalesce((salary+(commission_pct*salary)), salary+2000, nvl(salary,0)+5000, ) as "New Salary" 
from employees where employee_id in (100, 101, 158);


SELECT employee_id, last_name, salary, commission_pct, 
coalesce((salary+(commission_pct*salary)), salary+2000, nvl(salary,0)+commission_pct ) as "New Salary" 
from employees where employee_id in (100, 101, 158);





------------Aggregate functions

select max(salary) from employees;

select min(salary) from employees;

select count(*) from employees;

select avg(nvl(salary,0)) from employees;

--------Group functions

select department_id, sum(salary) from employees; -- error

select department_id, sum(salary) from employees
group by department_id;

select manager_id, sum(salary) from employees
group by manager_id;

select department_id, manager_id, job_id, sum(salary) from employees
group by department_id,manager_id,job_id

select department_id, manager_id, job_id, sum(salary) 
from employees
group by department_id,manager_id,job_id


select department_id, manager_id, sum(salary) from employees
group by department_id,manager_id;

----------WHERE in group by

select department_id, manager_id, job_id, sum(salary) 
from employees
where sum(salary) > 300000
group by department_id,manager_id,job_id

select department_id, manager_id, job_id, sum(salary) 
from employees
where department_id > 100
group by department_id,manager_id,job_id
having sum(salary) > 10000
order by department_id

----
--Print job id wise avg 
--- the avg should be > 12000
--- the employees should only belong to department_id 100
--- sort the result desc order of avg(salary)

select job_id,avg(salary) from employees 
where department_id=100 
group by job_id
having avg(salary)>2000
order by avg(salary) desc

select * from employees
---
--How many employees reporting to each manager


select count(*) from employees

select manager_id, count(employee_id) from employees group by manager_id;


select manager_id, count(*) from employees group by manager_id;


-------------------------JOINS


----NATURAL JOB
select employee_id, first_name, job_id, job_title from employees natural join jobs;

select * from employees where employee_id = 100;

select employee_id, first_name, department_id, department_name,manager_id from employees natural join departments;

select * from departments

select department_id,department_name,city from departments natural join locations;
---------------------------------------------------
----------display all employees who works in the same dept and manager heads the department - same
select employee_id, first_name, department_id, department_name,manager_id from employees natural join departments;

---using clause
select employee_id, first_name, department_id, department_name,manager_id from employees join departments
using (department_id)

---remove ambiguity
select employee_id, first_name, department_id, department_name from employees join departments
using (department_id)

select employee_id, first_name, employees.department_id, department_name from employees join departments
using (manager_id)


------------on clause
--- person details who is heading the department
select employee_id, first_name, employees.department_id, department_name from employees join departments
on employees.employee_id = departments.manager_id


----------------Outer join

select employee_id, first_name, employees.department_id, department_name from employees join departments
on employees.department_id = departments.department_id
-- 106

select employee_id, first_name, employees.department_id, department_name from employees left outer join departments
on employees.department_id = departments.department_id
-- 107

select employee_id, first_name, employees.department_id, department_name from employees right outer join departments
on employees.department_id = departments.department_id

select employee_id, first_name, employees.department_id, department_name from employees full outer join departments
on employees.department_id = departments.department_id

-------------------------------
---------self join (

select * from employees;

--- Neena reports to Steven
----Lex reports to Steven

select mgr.first_name || ' reports to ' || emp.first_name from employees emp join employees mgr
on emp.employee_id = mgr.manager_id;

-------------------------cross join

select * from employees cross join departments;
//107X27


//
select count(*) from departments;

------------------------------------


---Name of the person who is getting highest salary.

select max(salary) from employees;

select first_name from employees where salary = 17000;


------------------------------------
--Highest paid employee in each department

select first_name,  department_id, salary  from employees where salary = 
(select max(salary) from employees group by department_id)

select first_name,  department_id, salary  from employees where (department_id,salary) IN 
(select department_id,max(salary) from employees group by department_id)

------------------

select * from customer;
select * from trandetails;
select * from branch;
select * from account;
select * from loan;

----------------------------------------------------------------------------SET operators
create table retired_employees
as
select * from employees where employee_id in (102,103,104);


delete from employees where employee_id in (103,104);


select * from employees
union
select * from retired_employees;



select * from employees
union all
select * from retired_employees;


-----------------------------------------------------------

create table products 
(
    productId number ,
    ssnCode number,
    constraint pkSSnPId primary key(productId,ssnCode)
)

insert into products values (1,1);

insert into products values (1,2);

insert into products values (2,1);

select * from products;

drop table products;


create table products 
(
  productId number constraint pkId primary key,
  productName varchar2(20) constraint nnPname not null,
  price number,
  quantity number,
  review varchar2(20),
    constraint chkPrice check ( price > 0),
    constraint chkQty check ( quantity >= 0),
      constraint chkReview check( review in  ('Excellent','Good','Bad'))
)


select * from products;

create table orders
(
  orderId number primary key,
  orderDate date default sysdate,
  productId number,
  constraint fkPid foreign key (productId) references products(productId) on delete cascade
)

insert into products values(1009,'Mouse',100,9999,'Excellent');
insert into products values(1010,'Monitor',100,9999,'Excellent');



insert into orders values (104,default,null);

select * from products;
select * from orders;

delete from products where productId = 1009;




















describe employees;

insert into employees (employee_id,last_name,email,hire_date,job_id)values (300,'Sharma','sharma123',sysdate,'IT_PROG');

select * from employees where employee_id = 300;

update employees
set salary =  (select salary from employees where lower(first_name) = 'steven' FETCH FIRST 1 ROWS ONLY),
manager_id =100
where employee_id = 300;


-------Views

create or replace view empView
as
select employee_id,first_name,salary,job_id from employees
where department_id = 100
and job_id = 'FI_ACCOUNT'
with check option

select * from empView;

update empView 
set salary = salary +2000
where employee_id = 109;


update empView 
set job_id  = 'IT_PROG'
where employee_id = 110;

select * from employees where employee_id = 109;


create or replace view empViewSalary
as
select employee_id,first_name,salary,job_id from employees
where salary > 10000
with check option

select * from empViewSalary

update empViewSalary
set salary = 5000
where employee_id =1;


---------

create or replace view empsaldetails
as
select first_name,last_name,salary,commission_pct, (salary+salary*commission_pct)*12 as "Annual Salary" from employees;



select * from empsaldetails;












--------------------






** Each in every class in java belongs to some package.

String
System

** java.lang package gets automatically imported.

Thread 

---------------
number
	byte
	short
	int
	long

decimal
	float
	double

boolean
	boolean

	char

-



























