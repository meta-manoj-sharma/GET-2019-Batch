CREATE DATABASE studentdatabase;
USE studentdatabase;
CREATE TABLE student (
			
firstName varchar(255) NOT NULL,

lastName varchar(255) NOT NULL,

fathersName varchar(255) NOT NULL,	
		
Email varchar(40) UNIQUE NOT NULL,
			
Age int NOT NUll,
			
class VARCHAR(10) NOT NULL			
);
