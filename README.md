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



























---------------------------------------------

StringBuilder name = new StringBuilder("K");	- not thread safe..	JDK1.5
StringBuffer StringBuffer is designed as thread-safe 

class Hello
{
	int num1=900;
}
class DemoVariables extennds Hello
{
	//instance variable
	static int num2=200;	//class variables -- only one copy of this will remain in memory

	
	public void display(Demo d1)
	{
	
		super.num1++;
		
	}
	public void changeNumbers()
	{
		num2++;
	}
	public void display(){
		System.out.println("Num1 :"+num1);
		System.out.println("Num2 :"+num2);
	}
	public static void main(String args[])
	{
		Demo d1 = new Demo();
		Demo d2 = new Demo();
		d1.changeNumbers();
		d1.display(d2);
		d1.changeNumbers();
		d1.display();
		d2.display();
		System.out.println(d1.num1+d1.num2+d2.num1+d2.num2);
	
	}
}

--------------------


Blocks

	initlizatizer
	static initlizatizer






-------------------------------------------------

Abstract class and methods



Object class and its methods
-----------------------------------

toString()
equals
hashCode
clone



Product extends Object







Generics
Comparable
Comparator
java.lang.Cloneable




-------------------------------------------

Comparator
	- java.util
	- sort based on your requirements
	- functional interface
	- contains only one abstract method






model
	

	

	Employee
		properties
		getters ands setter



	EmployeeService
	
		saveEmployee(Employee employee)
		return true;

		calculateSalat(sal)
		return	 		


	main()
		Enter emp id;
		Enter emp name

		Employee employee = new Employee(empId,empName);

		EmployeeService empService = new EmployeeService();
		empService.saveEmployee(employee);

	
		
		


Collection
	
	List<accept duplicate>
		ArrayList	<iteration>, not thread safe
		LinkedList <frequent insertion or deletion>
		Vector - Vector is synchronized, meaning its methods are thread-safe

	Set
		HashSet < no order>
		LinkedHashSet <order is maintained>
		TreeSet <ordered>



java.lang
	- Comparable 
		- compare






Map (no duplicates - key)
-------------
	HashMap ( no order) - not thread safe, not sync
	TreeMap (sorted)
	LinkedHashmap ( order is maintained)
	HashTable (Sync  thread safe)

Key value

employeeId
salary






----------

Split Iterator 



import java.util.ArrayList;
import java.util.Spliterator;
import java.util.Arrays;

public class SplitIteratorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Spliterator<Integer> splitIterator = numbers.spliterator();

        // Split the iterator
        Spliterator<Integer> splitIterator2 = splitIterator.trySplit();

        // Process the first half (using tryAdvance)
        System.out.println("First half:");
        while (splitIterator.tryAdvance(System.out::println));

        // Process the second half (using forEachRemaining)
        System.out.println("\nSecond half:");
        if (splitIterator2 != null) {
            splitIterator2.forEachRemaining(System.out::println);
        }
    }
}



----------------------

 Runtime r = Runtime.getRuntime();
        int numOfHardwareThreads = r.availableProcessors();
        System.out.println(numOfHardwareThreads);

----------------------














Threading

java.lang.Thread	- run		class
java.lang.Runnable	- run		interface


class Food extends extends Thread

---------------------------------------------------------------------------------------------




Enter your name (30 seconds) : Neha

Welcome, Neha

after 30 seconds
Better luck next time




wait
notify




-----------------------------


ResultSet 	= statement.executeQuery(select)
int	statement.executeUpdate(DML)
boolean 	statement.execute(DDL)




PreparedStatement 		- ?



-------------------------------------------------------------

Modules

productlist
productdetails


package com.training.plist;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
		
	public static List<String> getProductList() {
		List<String> products = new ArrayList();
			products.add("Lakme");
			products.add("Aroma");
			products.add("Glass");
			return products;
	}
}


module productlist {
exports com.training.plist;
}


module productdetails {
requires productlist;
}



productdetails






**error will come . Hover and click fix project setup  Ok


package com.training.pdetails;

import java.util.List;

import com.training.plist.ProductList;

public class PrinntProductDetails {

	public static void main(String[] args) {
		List<String> products = ProductList.getProductList();
		
		System.out.println(products);
	}

}


------------
java.io package

--------------

Annotation



A Spliterator in Java 8 and later is an interface that allows for parallel processing of data by splitting it into smaller chunks. It's an iterator with added capabilities for determining the size of the data source and splitting it into sub-Spliterators. This makes it ideal for use with parallel streams, enabling efficient processing of large datasets across multiple threads




Statement	- static SQL
Prepp		- PARAMTERIZED
CallableStatement	


--------------------

Annotation
@override	- meta data information




Modules




Step1 : create new module named productlist
Step2: create a new file inside src/main/java	- module-info.java
Step3: create a class 

package com.training.plist;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
		
	public static List<String> getProductList() {
		List<String> products = new ArrayList();
			products.add("Lakme");
			products.add("Aroma");
			products.add("Glass");
			return products;
	}
}

Step4: update module-info.java
module productlist {
    exports com.training.plist;
}

Stp6 : Create another module named productdetails 
** use differennt name in package grooup id : com.hello
Step7 : create a new file inside src/main/java	- module-info.java
module productdetails {
    requires productlist;
}
Step8:open com.hello.Main.java
        System.out.println(ProductList.getProductList());
Step9: error will come, hover mouse and select -> add dependency
Step10 : add import com.training.plist.ProductList;







------------------
I/O
-------









































REST API
----------------

Expose REST API to perfrom  CRUD operation on product.

http://localhost:8080/product				- GET ALL THE PRODUCTS
http://localhost:8080/product/90			- GET A SINGLE PRODUCT By ID
http://localhost:8080/product/90/100			- GET A SINGLE PRODUCT By ID


To do
http://localhost:8080/product	/search/Mouse		- GET ALL PRODUCT By NAME	

http://localhost:8080/product/90			- DELETE A SINGLE PRODUCT By ID	- DELETE
http://localhost:8080/product/			- SAVE A SINGLE PRODUCT 		- POST
http://localhost:8080/product/			- UPDATE A SINGLE PRODUCT 	- PUT




Swagger
---------------

http://localhost:8080/swagger-ui/index.html


        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.8.5</version>
        </dependency>



http://localhost:8080/v3/api-docs


------------------Status codes

200		- su
300		- 
400		- error
500		- internal server codes






Ci/CD Session


Create a Build


http://localhost:8080


Welcome OFSS, Good morning

Continuous Integration and Continous Deployment


Jenkins
------------



Code 	-->	Git (https://github.com/tufailahm/message-api)

What we need

Jenkins

Git	- download and install git 
Maven


2)	Configure jenkins


Git repo : 
https://github.com/tufailahm/message-api
https://github.com/tufailahm/message-api.git


JDK 21




admin
root


OFSSMaven
OFSSJDK
OFSSGit


USe case : https://github.com/tufailahm/message-api.git


Hands on :  Create jenkins job that should trigger at 11:40 every day



Custom Pipeline
--------------------------------





























Javascript





file:///E:/Trainings/2025/4.OFSS/ofss202502/web/success.html?username=Navya&password=navya123&firstName=Navya&lastName=Pai&gender=on



file:///E:/Trainings/2025/4.OFSS/ofss202502/web/success.html?username=Navya&password=Navya123&firstName=Navya&lastName=Pai&gender=female


file:///E:/Trainings/2025/4.OFSS/ofss202502/web/success.html
?username=tufailcool&	&lastName=Ahmed&gender=male


file:///E:/Trainings/2025/4.OFSS/ofss202502/web/success.html?username=tufailcool&password=123&lastName=Ahmed&
gender=male&
communication=email&communication=sms&communication=notification



Hands on : Create a login Form like Below :


Please provide login details :

Username : 	[]	
Password :	[]
Role	:	[] -- Drop down -- Admin, Guest and Others
** Default option should be ---select role----

<Login>	- submit button

<Clear>	- clear button



Date


            function calculateTotalBill(day, month, year){
                var paidDate = new Date();
                paidDate.setFullYear(year, month, day);
                var dueDate = new Date();
                dueDate.setFullYear(year, month, 5);

                var billAmount = prompt("Enter bill amount", "8000");
                var defaultDays = 0;
                if(paidDate > dueDate){
                    alert("Pay fine!")
                    defaultDays = (paidDate - dueDate)/(1000*60*60*24);
                }
                var totalAmount = parseInt(billAmount) + defaultDays*50;
                alert("Total amount: "+totalAmount)
            }







Use case : We have a image in a web page, that needs to change on mouse over.





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
        <link type="text/css" href="styles.css" rel="stylesheet">

        <script>
            function changeImage(img){
                document.images[0].src =img
            }
        </script>
</head>
<body>
    <h2> Hover mouse over image to change</h2>
    <img src="1.jpg" height="300" width="300" 
        onmouseover="changeImage('2.jpg')" 
        onmouseout="changeImage('1.jpg')">
</body>
</html>


Login Form Validation 










































this in javascript
-------------------------------


Cookies
-------------------------------





Custom objects in javascript
------------------------------------------

All JavaScript coders eventually reach a stage where they would like to create and use their own objects, apart from the pre-built ones, such as document or Math. 
window

Custom objects allow you to build up your own personal JavaScript "toolbox" that extends beyond what the pre-build objects have to offer. 


How to create your own basic object
Creating an object requires two steps:

First, declare the object by using an object function

Lastly, instantiate the newly created object by using the "new" keyword

Lets take this one step at a time. We will now proceed to create an object called "userobject", which, at this stage, does nothing:


Step 1: declare the object by using an object function

function userobject(parameter){
}

----------------------
<script type="text/javascript">
function userobject(parameter){
}
//myobject is now an object of type userobject!
var myobject=new userobject("hi")
</script>




Thus far, our object "userobject" cannot do anything With some properties, that should all change. 
To add properties to a user defined object, directly embed the properties into the object function, with each property proceeded by the keyword "this" plus dot (.): 
function userobject(parameter)
{
this.firstproperty=parameter
this.secondproperty="This is the second property"
}
Now, to use these properties, simply access them like accessing any other property:
<script>
var myobject=new userobject("hi there.")
//alerts "hi there."
alert(myobject.firstproperty)
//writes "This is the second property"
document.write(myobject.secondproperty)
</script>


----------------


Adding methods to a user defined object is a bit more complicated. 

We need to first declare and define a function for each method, then associate this function with the object function. For the sake of simplicity, we will simply call functions defined for methods "method functions.

The first step to adding methods is to implement the method functions. Method functions define what a method does:

//first method function
function computearea(){
    var area=this.radius*this.radius*3.14
    return area
}


function computearea(radius){
        var area=radius*radius*3.14
        return area
    }
function userObject(parameter){
    this.firstProperty = parameter
    this.secondProperty = "Welcome in my second property"
    this.mymethod = computearea
}

var myObject = new userObject(“DemoUser")

console.log(myObject.firstProperty)
console.log(myObject.secondProperty)
console.log(myObject.mymethod(5))


------------------------------------------


HTML5 - localStorage and sessionStorage

-----------------------------------------------

Web Workers in HTML5 allow you to run JavaScript in the background, on a separate thread from the main UI thread. This is useful for performing heavy computations or background tasks without freezing the user interface.

Features :
Runs in the background (separate thread)

Doesn't block the main UI

Communicates via messages (using postMessage and onmessage)

Cannot access DOM directly

Limited to same-origin policy

🧠 Use Cases:
Data processing

Heavy calculations

Fetching large data from API

Image or video manipulation






Use case : Create dynamic HTML controls

Product Number : 	[	76 ] 

Product Address 1:		[	]

....

Product Address 76:		[	]







Communicating with a Remote Server -Ajax






-----------------Junit

When user logs in
Then they should enter password
public class Calculator
{
	public int sum(int num1,num2)
	{
		return num1+num1;
	}
}


-------------------


Junit 5	- jupiter

<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>6.0.0-M2</version>
    <scope>test</scope>
</dependency>


@Test
@DisplayName
@Order 
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)


Stub methods

@BeforeEach
@AfterEach
@AfterAll		- static
@BeforeAll	- static


Exceoption Testing

@Test
	void testconvertStringToNumber1() {
		System.out.println("### Test testconvertStringToNumber called");
		actual = calculator.convertStringToNumber("90");
		assertEquals(90, actual);
	}

	@Test
	@DisplayName("Testing convert to numbers \"Twenty\" ")
	void testconvertStringToNumber2() {
		expected = 20;
		System.out.println("### Test testconvertStringToNumber called");
		assertThrows(NumberFormatException.class, () -> {
			int actual = calculator.convertStringToNumber("20");
			assertEquals(expected, actual);
		});
	}


-----------------------------------


	@ParameterizedTest(name = "{index} - {0} and {1} should be {2}")
	@DisplayName("Testing calculator add")
	@CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
	public void testAdd(int num1,int num2,int expected)
	{
		Calculator calculator = new Calculator();
		int actual=calculator.add(num1,num2);
		assertEquals(expected, actual);
	}



----------------------------------------------------




   <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-report-plugin</artifactId>
                <version>3.0.0-M5</version> <!-- Use a recent version -->
            </plugin>
        </plugins>
    </build>

















