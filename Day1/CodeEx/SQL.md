-- DDL Goes here

CREATE TABLE person (
  person_id INT UNIQUE NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(100),
  last_name CHAR(100),
  salary DECIMAL(9, 2),
  created_At TIMESTAMP
);

ALTER TABLE person ADD COLUMN job VARCHAR(200);

-- DML
INSERT INTO person(first_name, last_name, salary, job) 
VALUE ("Joan", "Arkens", 68216.23, 'Engineer'),
('Jane', 'Doe', 73824, 'Cop'),
('John', 'Doe', 74891.4, 'Doctor'),
('Jake', 'McCalister', 8214839.83, 'Sailor'),
('Jason', 'Dade', 806319.63, 'Sailor');

UPDATE person SET job = 'Java Dev' WHERE person_id = 2;

-- DELETE FROM person WHERE person_id = 2;

SELECT * FROM person;

SELECT first_name FROM person;

SELECT first_name, last_name FROM person;

SELECT * FROM person WHERE last_name LIKE 'D%';
SELECT * FROM person WHERE last_name LIKE 'D_e';