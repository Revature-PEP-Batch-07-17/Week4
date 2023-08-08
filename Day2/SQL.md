-- DDL
CREATE TABLE vet(
  vet_id INT PRIMARY KEY,
  vet_name VARCHAR(100) NOT NULL UNIQUE,
  pet_type VARCHAR(100),
  salary DECIMAL(8,2) DEFAULT 60000 CHECK (salary < 95000),
  clinic_address VARCHAR(100),
  State VARCHAR(2),
  zip VARCHAR(5)
);

CREATE TABLE pet(
  pet_id SERIAL PRIMARY KEY,
  pet_name VARCHAR(100) NOT NULL,
  pet_owner VARCHAR(100),
  microchipped BOOLEAN,
  pet_type VARCHAR(100),
  vet_id INT REFERENCES vet(vet_id)
);

-- DML
INSERT INTO vet(vet_id, vet_name, pet_type, salary, clinic_address, State, zip)
    VALUES (0012, 'Adam', 'Dog', 94000, '12312 W. Doggy Ln.', 'CA', '54323');
INSERT INTO vet(vet_id, vet_name, pet_type, clinic_address, state, zip)
	VALUES (0013, 'Lily', 'Cat', '43456 Treatment Rd.', 'LA', '32423');
INSERT INTO vet(vet_id, vet_name, pet_type, clinic_address, state, zip)
	VALUES (0014, 'James', 'Hamster', '43456 Treatment Rd.', 'LA', '32423');
INSERT INTO vet(vet_id, vet_name, pet_type, clinic_address, state, zip)
	VALUES (0015, 'Charles', 'Horse', '53132 Over Here Rd.', 'WA', '65344');

    
INSERT INTO pet(pet_name, pet_owner, microchipped, pet_type, vet_id)
VALUES ('Lollipop', 'Brittany', true, 'Dog', 0012),
  ('Creamsicle', 'Dylan', false, 'Cat', 0012),
  ('Ralph', 'Keven', false, 'Lizard', null),
  ('Pajamas', 'Nancy', true, 'Hamster', 0014),
  ('Sam', 'Cynthia', false, 'Dog', 0012),
  ('Polly', 'Joseph', true, 'Parrot', null);
  
UPDATE pet SET vet_id = 0013 WHERE pet_id = 2;

-- SELECT statements we used:
SELECT * FROM vet;

SELECT * FROM pet;

-- I want to know what type of pets visit my clinic
SELECT pet_type FROM pet;

-- I want the salaries of all my employees at a specific clinic
SELECT salary, vet_name FROM vet WHERE clinic_address = '43456 Treatment Rd.';

-- I want a list of all the pets my clinics specialize in and who the vet is
SELECT vet_name, pet_type FROM vet;

-- Joins
SELECT pet.pet_name, pet.pet_owner, pet.pet_type, vet.vet_name
FROM pet
INNER JOIN vet
ON vet.pet_type = pet.pet_type;

SELECT pet.pet_name, pet.pet_owner, pet.pet_type, vet.vet_name
FROM pet
LEFT JOIN vet
ON vet.pet_type = pet.pet_type;

SELECT pet.pet_name, pet.pet_owner, pet.pet_type, vet.vet_name
FROM pet
RIGHT JOIN vet
ON vet.pet_type = pet.pet_type;

SELECT pet.pet_name, pet.pet_owner, pet.pet_type, vet.vet_name
FROM pet
FULL JOIN vet
ON vet.pet_type = pet.pet_type;