create database shoppingcart;
use shoppingcart;

CREATE TABLE user (
  userId int NOT NULL AUTO_INCREMENT,
  UserName varchar(25) UNIQUE NOT NULL,
  PRIMARY KEY (userId) ) ;

CREATE TABLE product (
ProductCode varchar(50) UNIQUE NOT NULL,
ProductName varchar(50) NOT NULL,
Type varchar(25) NOT NULL,
Price double NOT NULL,
PRIMARY KEY (ProductCode) );

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P1' , 'AcerLaptop' , 'Laptop' , 40000.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P2' , 'AcerLaptop' , 'Laptop' , 45000.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P3' , 'DellLaptop' , 'Laptop' , 46000.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P4' , 'DellLaptop' , 'Laptop' , 43000.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P5' , 'Puma Shoe' , 'Shoe' , 4000.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P6' , 'Reebok Shoe' , 'Shoe' , 4200.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P7' , 'Relaxo Shoe' , 'Shoe' , 4900.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P8' , 'Bata Shoe' , 'Shoe' , 4070.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P9' , 'Melody' , 'Toffee' , 2.0);

INSERT INTO product (ProductCode , ProductName , Type , Price ) 
Values ('P10' , 'Eclairs' , 'Toffee' , 3.0);



CREATE TABLE cart (
  userId int,
  ProductCode varchar(50) NOT NULL,
  Quantity int(50) NOT NULL,
  FOREIGN KEY (ProductCode) REFERENCES Product(ProductCode),
 FOREIGN KEY (userId) REFERENCES user(userId)) ;