drop schema employee;
CREATE database employee;
use employee;

CREATE TABLE employee (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(255) NOT NULL,
  Gender varchar(6) NOT NULL,
  Email varchar(255) NOT NULL,
  Password varchar(15) NOT NULL,
  Number varchar(15) NOT NULL,
  Company varchar(50) NOT NULL,
  ProfilePhtotoUrl varchar(200) NOT null,
  PRIMARY KEY (Id),
  UNIQUE KEY Email (Email)
);


CREATE TABLE vehicle (
  VehicleId int(11) NOT NULL AUTO_INCREMENT,
  Email varchar(45) NOT NULL,
  Name varchar(255) NOT NULL,
  Type varchar(50) NOT NULL,
  Number varchar(255) NOT NULL,
  EmployeeId varchar(15) NOT NULL,
  Details varchar(255) NOT NULL,
  PRIMARY KEY (Email,VehicleId),
  KEY VehicleId (VehicleId),
   FOREIGN KEY (Email) REFERENCES employee (Email)
);


CREATE TABLE plandetails (
  PlanId int(11) NOT NULL AUTO_INCREMENT,
  VehicleId int(11) NOT NULL,
  Email varchar(45) NOT NULL,
  Currency varchar(3) NOT NULL,
  Price varchar(50) NOT NULL,
  PRIMARY KEY (PlanId),
  KEY Email (Email),
  KEY VehicleId (VehicleId),
  KEY PlanId (PlanId),
   FOREIGN KEY (Email) REFERENCES vehicle (Email),
 FOREIGN KEY (VehicleId) REFERENCES vehicle (VehicleId)
);




