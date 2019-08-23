use Store;
INSERT INTO user (userid,Name,Email,Password,Phone,UserType)
VALUES('s001','Pankaj','pankaj@gmail.com','password',1111111111,'admin');
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s002','Shreyash','Shreyash@gmail.com','password',2222222222);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s003','Manoj','Manoj@gmail.com','password',3333333333);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s004','vinay','vinaykumar@gmail.com','password',4444444444);
INSERT INTO user (userid,Name,Email,Password,Phone)
VALUES('s005','Sabir','Sabir@gmail.com','password',5555555555);
INSERT INTO user (userid,Name,Email,Password,Phone,UserType)
VALUES('s006','abhi','abhi@gmail.com','password',5555555555,'admin');

/**
  * Data Insertion in Shopper Table
  */


insert into Category(CategoryID,CategoryName,ParentCategoryTitle)
values 
('c001','Computer','TopCategory'),
('c002','Accesories','c001'),
('c003','MemoryCard','c001'),
('c004','Clothing','TopCategory'),
('c005','Women','c004'),
('c006','Shirt','c011'),
('c007','FormalShirt','c006'),
('c008','T-Shirt','c011'),
('c009','Electronics','TopCategory'),
('c010','Headphones','c009'),
('c011','Men','c004'),
('c012','MemoryCard','c009');

select * from category;

insert into Products(ProductID,ProductName,Description,Price,Quantity,isInStock,CategoryID,instockdate)
values 
('p001','MI NOTE 8','It is a smartphone with full functionality','250','120',true,'c009','2019-06-12'),
('p002','Swiss Watch','It is a smartphone with full functionality','215','20',true,'c009','2019-01-19'),
('p003','MonteCarle T-shirt','It is a branded T-shirt','50','40',true,'c011','2019-03-1'),
('p009','MonteCarle T-shirt','It is a branded T-shirt','50','40',true,'c004','2019-07-22'),
('p004','WomanJeans Denim','These include denim jean for woman','100','200',true,'c005','2019-05-18'),
('p005','Samsung Memeory Card','It is for storing data','90','10',true,'c002','2019-07-11'),
('p006','Acer Mouse','It is a mouse for computer','500','400',true,'c001','2019-07-12'),
('p007','UCM Formal-shirt','It is a formal shirt','6000','0',false,'c004','2019-07-1');





select * from products;




INSERT INTO images(ImageID,Imagetype,Imageurl,ProductID)
VALUES
('i001','.jpg','c\:images\frog.png','p001'),
('i002','.jpg','c\:images\img1.png','p001'),
('i003','.jpg','c\:images\img2.png','p002'),
('i004','.jpg','c\:images\img3.png','p003');

select * from Images;




insert into address(AddressID,userID,houseNo,colony,city,state,zipcode)
Values
('a001','s001','p1','Shastri Nagar','Jaipur','Rajasthan','302012'),
('a002','s001','p2','Malviya nagar','Jaipur','rajasthan','302016'),
('a003','s002','p45','Jagatpura','Jaipur','rajasthan','302034'),
('a004','s003','p48','Tonk Phatak', 'Jaipur','rajasthan','302048'),
('a005','s003','p4','Raja Park ','Jaipur','rajasthan','302022'),
('a006','s004','p6','Shastri Nagar' ,'Jaipur','rajasthan','302026');



select * from address;




INSERT INTO orders(OrderID,OrdershippingStatus,Date,AddressId,userID)
VALUES
('o001','cancelled','2019-07-13','a001','s004'),
('o002','placed','2019-07-10','a002','s002'),
('o003','placed','2019-07-3','a003','s003'),
('o004','placed','2019-08-2','a004','s004'),
('o005','cancelled','2019-07-1','a005','s005');


select * from orders;


INSERT INTO cart(ItemID,OrderID,ProductID,Quantity,Amount,itemshippingstatus)
VALUES
('i001','o001','p001','5','60','shipped'),
('i002','o001','p002','2','50','cancelled'),
('i003','o001','p003','5','30','returned'),
('i004','o002','p001','15','40','shipped'),
('i005','o003','p008','1','64','shipped'),
('i006','o004','p011','1','45','shipped'),
('i007','o004','p003','2','32','shipped'),
('i008','o004','p005','10','645','shipped'),
('i009','o004','p005','10','645','cancelled'),
('i010','o004','p005','10','645','cancelled');
select * from cart;



set foreign_key_checks=1;


