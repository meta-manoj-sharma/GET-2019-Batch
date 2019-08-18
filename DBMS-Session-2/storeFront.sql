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
CREATE TABLE shopper (
		ShopperId varchar(10) NOT NULL,
			PRIMARY KEY (ShopperId),
			FOREIGN KEY (ShopperId) REFERENCES user (userId)
			);

CREATE TABLE admin (
  			AdminId varchar(10) NOT NULL,
  			AdminKey VARCHAR(10) NOT NULL,
  			PRIMARY KEY (AdminId),
  			FOREIGN KEY (AdminId) REFERENCES user (UserId)
	);
    
CREATE TABLE Category (
    CategoryId VARCHAR(20) NOT NULL PRIMARY KEY,
    CategoryName VARCHAR(50),
    ParentCategoryTitle varchar(25) references category
);
/* to create product table*/
drop table products;
CREATE TABLE Products (
    ProductId VARCHAR(20) NOT NULL PRIMARY KEY,
    CategoryId VARCHAR(20) NOT NULL,
    CategoryName VARCHAR(20) NOT NULL,
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
    ImageCategory varchar(20),
    ImageData blob,
    ProductID varchar(6) NOT NULL,
    PRIMARY KEY (ImageID),
    FOREIGN KEY (ProductID) references Products (ProductID)
);

CREATE TABLE Address (
    AddressId varchar(10),
    ShopperID varchar(10) NOT NULL,
    OrderID varchar(10),
    houseNo varchar(10),
    colony varchar(100),
    city varchar(20),
    state varchar(20),
    country varchar(20) default 'INDIA',
    ZipCode VARCHAR(6) NOT NULL,
    PRIMARY KEY (AddressId),
    FOREIGN KEY (ShopperID) references Shopper(ShopperID)
);

CREATE TABLE Orders (
    OrderID varchar(10),
    OrderStatus varchar(20) CHECK (OrderStatus IN ('PLACED' , 'CANCELLED')),
    Date DATE,
    AddressId varchar(100),
    ShopperID varchar(10),
    Amount INT NOT NULL,
    PRIMARY KEY (OrderID),
    FOREIGN KEY (ShopperID) references Shopper (ShopperID),
    FOREIGN KEY (addressID) references Address (addressID)
);

CREATE TABLE Payment (
    ShopperId VARCHAR(20) NOT NULL,
    OrderId VARCHAR(20) NOT NULL,
    Type VARCHAR(50) NOT NULL,
    PaymentId VARCHAR(20) NOT NULL PRIMARY KEY,
    Amount INT NOT NULL,
    Date DATE NOT NULL,
    FOREIGN KEY (ShopperId) REFERENCES Shopper (ShopperId),
    FOREIGN KEY (OrderId) REFERENCES Orders (OrderId)
);


CREATE TABLE Cart (
    ItemID varchar(10) NOT NULL,
    OrderID varchar(10),
    ProductID varchar(10),
    Quantity int,
    Amount int,
    OrderStatus varchar(20) CHECK (OrderStatus IN ('SHIPPED' , 'CANCELLED', 'RETURNED')),
    PRIMARY KEY (ItemID),
    FOREIGN KEY (OrderID) references Orders (OrderID),
    FOREIGN KEY (ProductID) references Products (ProductID)
);

/* to show tables*/
SHOW tables;

SET FOREIGN_KEY_CHECKS = 0;

/* to delete product table*/
DROP TABLE Products;
/* to create product table again*/
CREATE TABLE Products (
    ProductId VARCHAR(20) NOT NULL PRIMARY KEY,
    CategoryId VARCHAR(20) NOT NULL,
    categoryName VARCHAR(100) NOT NULL,
    ProductName VARCHAR(50),
    Description VARCHAR(100),
    Price INT,
    Quantity INT,
    isInStock BOOLEAN,
    FOREIGN KEY (CategoryID) references Category (CategoryID)
);

