-- See flyway for more information about database automatic migration :)


DROP SEQUENCE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS student_personal_information;
DROP TABLE IF EXISTS student_school_information;


-- starts the primary key value automatic generation at 1000 w/ increment of 1
CREATE SEQUENCE hibernate_sequence START 1000 INCREMENT 1;

----------------------------------------------------------------
-- CREATE TABLES and IMPORT TEST DATA
-----------------------------------------------------------------

CREATE TABLE student_personal_information (
    id INT8 NOT NULL,
	  LastName VARCHAR(255) NOT NULL,
    FirstName VARCHAR(255),
	  MiddleInitial CHAR(5),
	  Age INT,
    Image BYTEA,
    PRIMARY KEY (id)
);

CREATE TABLE student_school_information (
    id INT8 NOT NULL,
	  Year INT,
	  Section INT,
	  Course CHAR(5),
    PRIMARY KEY (id)
);
