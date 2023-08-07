# Structured Query Language (SQL):

## Relational Database Management System (RDBMS):
- A software used to store, manage query and retrieve data stored in a relational database.
- Many to choose from with SQL: PostgreSQL, MySQL, SQLite, Oracle

## How is data structured?

| id | firstName | lastName | department | reportsTo |
| -- | --------- | -------- | ---------- | --------- |
|  1 | Jimmy     | Johnson  |          1 |      NULL |
|  2 | Aaron     | Anderson |          1 |         1 |
|  3 | Emily     | Emerson  |          1 |         1 |

**Column:**
- Vertical; used to hold a group of data referencing the same column name. When creating tables you specify columns.

**Row/Record:**
- Horizontal; used to hold data referencing a certain entity in a table. When inserting data into a table, you are inserting rows

## SQL SubLanguages:
- Data Definition Language (DDL):
    * CREATE, ALTER, DROP, TRUNCATE

- Data Manipulation Language (DML):
    * INSERT INTO
    * SELECT
    * DELETE
    * UPDATE

- Data Control Language (DCL):
    * GRANT
    * REVOKE

- Transaction Control Language (TCL):
    * SAVEPOINT
    * ROLLBACK

## SQL DataTypes:
- Character
    * CHAR(100)
    * VARCHAR(100)
    * TEXT

- Numeric
    * DECIMAL(5,2) <-- 5 total numbers, 2 total places after the decimal
    * FLOAT(precision, scale)
    * INTEGER

- Temporal
    * DATE, TIME, TIMESTAMP
