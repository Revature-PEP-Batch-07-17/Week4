/*
 * Schemas allow you to organize your data within a database.
 * You can think of Schemas as similar to 'packages' in java.
 * 
 * SCHEMA
 * 		TABLE
 * 			COLUMNS/ROWS (DATA)
 */

/*
 * DDL - Data Definition Language
 */
--CREATE A TABLE:
create table lecture.employees (
--	<column_name> <column_type>,
	emp_id INTEGER, -- ID will be used to identify employees
	emp_name VARCHAR(50), -- VARCHAR is typically used for string data
	emp_salary DECIMAL,
	emp_title VARCHAR(20)
);

/*
 * DML - Data Manipulation Language
 */
--In SQL, String data within queries should use single quotes
insert into lecture.employees values (1000, 'Patty', 120000, 'CEO');
insert into lecture.employees values (1001, 'Matt', 45000, 'employee');
insert into lecture.employees values (1002, 'Jill', 50000, 'employee');
insert into lecture.employees values (1003, 'Phil', 75000, 'supervisor');
insert into lecture.employees values (1004, 'Will', 55000, 'employee');
insert into lecture.employees values (1005, 'Bob', 80000, 'supervisor');
insert into lecture.employees values (1006, 'Sally', 52000, 'employee');

--Values inserted into our tables are case-sensitive
insert into lecture.employees values (1007, 'Sarah', 50000, 'Employee');
insert into lecture.employees values (1008, 'Bobby', 50000, 'Employee');


--You do not need the schema qualifier if you have selected the schema in DBeaver specifically
update employees set emp_name='Gill' where emp_id=1002;
UPDATE lecture.employees SET EMP_SALARY=100000000 WHERE emp_id = 1000;

UPDATE employees SET emp_title='employee' WHERE emp_id = 1007;
UPDATE employees SET emp_title='employee' WHERE emp_id = 1008;
--Remove all records from employees table
--delete from lecture.employees;

--Remove a specific record - this would delete Patty if we run it...
--delete from lecture.employees where emp_id=1000;

/*
 * Order of SQL Statements:
 * SELECT <columns> FROM <table> WHERE <clause> GROUP BY <column> HAVING <clause> ORDER BY <direction>
 */

-- The asterisk is used to reference all columns of a table
select * from employees;

--We can specify columns if we do not need all data
select emp_id, emp_name from lecture.employees;


/* WHERE STATEMENT 
 * 	This statement allows you to filters results based on specific criteria 
 * 	Where can be  used in combination with other clauses (between, in, like, etc...)
 */
-- Select all employses who make over $70,000
select * from employees where emp_salary > 70000;

-- Select the employee whose emp_id is 1000
select emp_name, emp_title from employees where emp_id = 1000;



/* GROUP BY 
 * 	This statement allows you to combine data (look at your data based on 
 * 		an aggregate specified from your result set)
 */
-- This statement allows us to see the average salary of all employees based on employeee level (emp_title)
SELECT AVG(emp_salary), emp_title from lecture.employees group by emp_title;

-- Showcases all employee titles, but doesn't help us know examples how many different titles we have...
select emp_title from employees;

-- Showcase the different, distinct employee titles
select emp_title from employees group by emp_title;


/* HAVING 
 * 	This statement allows you to perform another filter (similar to 'Where', AFTER you have
 * 		grouped your data)
 */
-- 'supervisors' are included here:
SELECT sum(emp_salary), emp_title from lecture.employees group by emp_title;

-- 'supervisors' are NOT included in this result set:
select sum(emp_salary), emp_title from lecture.employees 
group by emp_title having sum(emp_salary) > 175000;



/* ORDER BY 
 * 	This statement allows you to sort the data in a specific order (lowest-to-highest, top-to-bottom, etc...)
 * ASC = 'lowest-to-highest'
 * DESC = 'highest-to-lowest'
 * note that depending on the SQL dialect, the keywords of 'ASC' and 'DESC' might differ.
 */
select * from employees;

SELECT * FROM employees ORDER BY emp_id ASC;

--ORDER BY uses an ascending or descending order
select * from employees order by emp_salary desc;
--We can include multiple columns to order by using a comma to separate
select * from employees order by emp_title desc, emp_salary asc;
--Upper case letters have a 'higher' value, so they are first when we descend the ordering



/* ALL TOGETHER 
 * Typically your statements will not be this complex...
 * 
 * This statement will return the average salary of employees who make less than $100,000
 * whose AVERAGE is less than $70,000
 * 
 * For instance:
 * 	Supervisor a makes 90,000
 * 	Supervisor b makes 90,000.
 * 
 * The average is 90,000. These would NOT be returned.
 * 
 * 	Employee c makes 50,000
 * 	Employee d makes 70,000.
 * The average is 60,000. These WOULD be returned.
 */
select avg(emp_salary), emp_title
from lecture.employees
where emp_salary < 100000
group by emp_title
having avg (emp_salary) < 80000
order by emp_title desc;



/* ALIASES 
 * 	An Alias allows you to provide a different name to a column in your statements and result set.
 * 
 * This can be helpful for:
 * 	-Readability
 * 	-Security (at a minor level)
 * 	-Trim down Verbose SQL queries
 */
--AS is used to specify an 'alias' for data we retrieve from our db
--Use double-quotes when we do not insert the string into a table
select emp_salary as "Money" from employees;



/* LIKE
 *	This keyword allows you to search for data that matches a pattern
 */
-- for strings the % is used for a wildcard for any number of characters
-- essentially this is saying "does the employee's name have an 'a' somewhere in it?"
select * from employees where lower(emp_name) like '%a%';
--emp_name = 'Dan' <-- WILL WORK
--emp_name = 'Hal' <-- WILL WORK
--emp_name = 'Aaron' <-- WILL WORK
--emp_name = 'Bill' <-- NOT WORK




-- for strings the _ is used for a wildcard for a single character
-- This query is looking for employees whose name is any letter, followed by 'a', then followed by 3 other letters
SELECT * FROM EMPLOYEES WHERE lower(emp_name) LIKE '_a___';
--emp_name = 'Danny' <-- WILL WORK
--emp_name = 'Halie' <-- WILL WORK
--emp_name = 'Aaron' <-- WILL WORK
--emp_name = 'Bill' <-- NOT WORK
--emp_name = 'Kate' <-- NOT WORK


-- You can combine both '%' and '_'
select * from employees where lower(emp_name) like 's_%a%';


/* BETWEEN 
 * 	Allows you to specify a range as part of a WHERE clause
 */
--Use the 'AND' keyword to specify upper and lower limits of a BETWEEN operation
select * from employees where emp_salary between 45000 and 75000;
SELECT emp_name, emp_salary FROM employees WHERE emp_salary BETWEEN 50000 AND 70000;


/* IN 
 * 	Allows you to specify a specific set of values as part of a WHERE clause
 */
-- Select all the 'employees' and 'supervisors'
select * from employees where lower(emp_title) in ('employee', 'supervisor');

-- The following two statements are essentially the same...usually its not useful to use 'IN' with a single value...
SELECT emp_name, emp_title FROM lecture.employees WHERE lower(emp_title) IN ('supervisor');
SELECT emp_name, emp_title FROM lecture.employees WHERE lower(emp_title) = 'supervisor';

/* LIMIT & OFFSET 
 * 	LIMIT allows you to only find some number of records ("Top 10 results", for instance)
 * 	OFFSET allows you to start your result set after skipping some number of records ("Give me to second best result")
 */
-- Get all employees
SELECT * FROM employees;

-- Get 2 employees
SELECT * FROM employees LIMIT 2;

-- Get 2 employees, but first skip the first 3 records
SELECT * FROM employees LIMIT 2 OFFSET 3;