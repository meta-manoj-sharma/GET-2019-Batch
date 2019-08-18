use Store;
INSERT INTO user (userid,Name,Email,Password,Phone,UserType)
VALUES('s001','Pankaj','pankaj@gmail.com','password',1111111111,'admin');
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s002','Shreyash','Shreyash@gmail.com','password',2222222222);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s003','Manoj','Manoj@gmail.com','password',3333333333);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s004','vinay','pankajkumar@gmail.com','password',4444444444);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s005','Sabir','Sabir@gmail.com','password',5555555555);
INSERT INTO user (userid,Name,Email,Password,Phone,UserType)
VALUES('s006','abhi','abhi@gmail.com','password',5555555555,'admin');

/**
  * Data Insertion in Shopper Table
  */
INSERT INTO shopper (shopperId)
Select userId from user where UserType='Shopper';


insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c001','Computer','TopCategory');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c002','Accesories','Computer');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c003','MemoryCard','Computer');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c004','Clothing','TopCategory');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c005','Women','Clothing');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c006','Shirt','Men');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c007','FormalShirt','Shirt');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c008','T-Shirt','Men');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c009','Electronics','TopCategory');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c010','Headphones','Electronics');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c011','Men','Clothing');
insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values ('c012','MemoryCard','Electronics');

select * from category;

insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p001','MI NOTE 8','It is a smartphone with full functionality','250','120',true,'c001','electronics','2019-06-12');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p002','Swiss Watch','It is a smartphone with full functionality','215','20',true,'c002','electronics','2019-01-19');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p003','MonteCarle T-shirt','It is a branded T-shirt','50','40',true,'c011','men','2019-03-1');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p009','MonteCarle T-shirt','It is a branded T-shirt','50','40',true,'c011','Clothing','2019-07-22');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p004','WomanJeans Denim','These include denim jean for woman','100','200',true,'c005','Women','2019-05-18');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p005','Samsung Memeory Card','It is for storing data','90','10',true,'c003','electronics','2019-07-11');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p006','Acer Mouse','It is a mouse for computer','500','400',true,'c002','Computer','2019-07-12');
insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,CategoryName,instockdate)
values ('p007','UCM Formal-shirt','It is a formal shirt','6000','0',false,'c007','clothing','2019-07-1');





select * from products;




INSERT INTO images(ImageID,ImageCategory,ImageData,ProductID)
VALUES
('i001','.jpg','c\:images\frog.png','p001'),
('i002','.jpg','c\:images\img1.png','p001'),
('i003','.jpg','c\:images\img2.png','p002'),
('i004','.jpg','c\:images\img3.png','p003');

select * from Images;

select * from shopper;


insert into address(AddressID,ShopperID,orderId,houseNo,colony,city,state,zipcode)
Values
('a001','s001','o001','p1','Shastri Nagar','Jaipur','Rajasthan','302012'),
('a002','s001','o002','p2','Malviya nagar','Jaipur','rajasthan','302016'),
('a003','s002','o003','p45','Jagatpura','Jaipur','rajasthan','302034'),
('a004','s003','o004','p48','Tonk Phatak', 'Jaipur','rajasthan','302048'),
('a005','s003','o005','p4','Raja Park ','Jaipur','rajasthan','302022'),
('a006','s004','o006','p6','Shastri Nagar' ,'Jaipur','rajasthan','302026');



select * from address;




INSERT INTO orders(OrderID,OrderStatus,Date,AddressId,ShopperID,amount)
VALUES
('o001','cancelled','2019-07-13','a001','s001','200'),
('o002','placed','2019-07-10','a002','s002','300'),
('o003','placed','2019-07-3','a003','s003','350'),
('o004','placed','2019-08-2','a004','s004','260'),
('o005','cancelled','2019-07-1','a005','s005','390');


select * from orders;


INSERT INTO cart(ItemID,OrderID,ProductID,Quantity,Amount,orderstatus)
VALUES
('i001','o001','p001','5','60','shipped'),
('i002','o001','p002','2','50','cancelled'),
('i003','o001','p003','5','30','returned'),
('i004','o002','p001','15','40','shipped'),
('i005','o003','p008','1','64','shipped'),
('i006','o004','p011','1','45','shipped'),
('i007','o004','p003','2','32','shipped'),
('i008','o004','p005','10','645','shipped');

select * from cart;






/*Part 2*/

select ProductID,ProductName,Price,Quantity,isInStock,categoryName,instockdate
from Products
where isInStock=true
order by instockDate desc;

select Products.ProductName
from Products
left join images
on images.ProductID=Products.ProductID
where images.ImageID IS null;

select CategoryID,CategoryName,ParentCategoryTitle
from category
order by ParentCategoryTitle,CategoryName ASC;

select CategoryID,CategoryName,ParentCategoryTitle
from category where categoryName not in (select ParentCategoryTitle from category);

select ProductName,Description,price
from Products
where CategoryName='electronics';

select ProductName,Price,Description,CategoryName,Quantity
from Products
where Quantity<='50';


