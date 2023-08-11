CREATE TABLE items (
	item_id int PRIMARY KEY,
	item_name varchar(200),
	item_price decimal
);

INSERT INTO lecture.items VALUES(1,'super soaker', 9.99);
INSERT INTO lecture.items VALUES(2,'teddy bear', 12.99);
INSERT INTO lecture.items VALUES(3,'yo yo', 7.99);

SELECT * FROM lecture.items;

GRANT INSERT, SELECT, UPDATE, DELETE ON lecture.items TO joe;