CREATE DATABASE store;
USE store;
CREATE TABLE user (
			
UserId varchar(10) NOT NULL,
			
Name varchar(255) NOT NULL,
			
Email varchar(40) UNIQUE NOT NULL,
			
Password varchar(20) NOT NULL,
			
Phone VARCHAR(10) NOT NULL,
  			
UserType varchar(7) NOT NULL DEFAULT 'Shopper',
  			
PRIMARY KEY (UserId)
			
);

CREATE TABLE Category (
    
CategoryId VARCHAR(20) NOT NULL PRIMARY KEY,
    
CategoryName VARCHAR(50),
    
ParentCategoryTitle varchar(25)
);


/* to create product table*/

CREATE TABLE Products (
    
ProductId VARCHAR(20) NOT NULL PRIMARY KEY,
    
CategoryId VARCHAR(20) NOT NULL,
    
ProductName VARCHAR(50),
    
Description VARCHAR(100),
    
Price INT,
    
Quantity INT,
    
isInStock BOOLEAN,

instockDate date,
    
FOREIGN KEY (CategoryID) references Category (CategoryID)
);



CREATE TABLE Images (
    
ImageID varchar(10),
    
Imagetype varchar(20),
    
ImageUrl varchar(100),
    
ProductID varchar(6) NOT NULL,
    
PRIMARY KEY (ImageID),
    
FOREIGN KEY (ProductID) references Products (ProductID)
);



CREATE TABLE Address (
    
AddressId varchar(10),
    
userID varchar(10) NOT NULL,
    
houseNo varchar(10),
    
colony varchar(100),
    
city varchar(20),
    
state varchar(20),
    
country varchar(20) default 'INDIA',
    
ZipCode VARCHAR(6) NOT NULL,
    
PRIMARY KEY (AddressId),
    
FOREIGN KEY (userID) references user(userID)
);



CREATE TABLE Orders (
    
OrderID varchar(10),
    
ordershippingstatus varchar(20) CHECK (Ordershippingstatus IN ('PLACED' , 'CANCELLED')),
    
Date DATE,
    
AddressId varchar(100),
    
userID varchar(10),
    
PRIMARY KEY (OrderID),
    
FOREIGN KEY (userID) references user(userID),
    
FOREIGN KEY (addressID) references Address (addressID)
);



CREATE TABLE Payment (
    
userId VARCHAR(20) NOT NULL,
    
OrderId VARCHAR(20) NOT NULL,
    
Type VARCHAR(50) NOT NULL,
    
PaymentId VARCHAR(20) NOT NULL PRIMARY KEY,
    
Date DATE NOT NULL,
    
FOREIGN KEY (userId) REFERENCES user (userId),
    
FOREIGN KEY (OrderId) REFERENCES Orders (OrderId)
);



CREATE TABLE Cart (
    
ItemID varchar(10) NOT NULL,
    
OrderID varchar(10),
    
ProductID varchar(10),
    
Quantity int,
    
Amount int,
    
itemshippingstatus varchar(20) CHECK (itemshippingstatus IN ('SHIPPED' , 'CANCELLED', 'RETURNED')),
    
PRIMARY KEY (ItemID),
    
FOREIGN KEY (OrderID) references Orders (OrderID),
    
FOREIGN KEY (ProductID) references Products (ProductID)
);

set sql_safe_updates=0;
set foreign_key_checks=0;

/* to show tables*/

SHOW tables;



