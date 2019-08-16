use Store;

insert into Admin(AdminID,userId,Password) 
values ('1' ,'2','1234');
insert into user(userName,userId) 
values ('manoj' ,'1'),
('abhi' ,'2'),
('varun' ,'3');
select * from admin;

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

select * from category;

insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p001','MI NOTE 8','It is a smartphone with full functionality','25000','120',true,'c001','electronics');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p002','Swiss Watch','It is a smartphone with full functionality','215000','20',true,'c002','electronics');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p003','MonteCarle T-shirt','It is a branded T-shirt','5000','40',true,'c011','men');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p004','WomanJeans Denim','These include denim jean for woman','1000','200',true,'c005','Women');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p005','Samsung Memeory Card','It is for storing data','900','10',true,'c003','electronics');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p006','Acer Mouse','It is a mouse for computer','500','400',true,'c002','Computer');
insert into Products(ProductID,ProductName,Description,Price,Quantity,StockStatus,CategoryID,CategoryName)
values ('p007','UCM Formal-shirt','It is a formal shirt','6000','0',false,'c007','clothing');





select * from products;




INSERT INTO images(ImageID,ImageCategory,ImageData,ProductID)
VALUES
('i001','.jpg','c\:images\frog.png','p001'),
('i002','.jpg','c\:images\img1.png','p001'),
('i003','.jpg','c\:images\img2.png','p002'),
('i004','.jpg','c\:images\img3.png','p003');

select * from Images;


INSERT INTO shopper (ShopperID, userId, Contact, Email,Password)
VALUES
('s001','1','9856451478','vk@gmail.com','1789'),
('s002','2','9235651478','ak@gmail.com','1789'),
('s003','2','9517812455','kun@gmail.com','1789'),
('s004','3','9666451478','vajik@gmail.com','1789'),
('s005','2','9266851478','ajunvk@gmail.com','1789'),
('s009','2','9266851478','ajunvk@gmail.com','1789');
select * from shopper;


insert into address(AddressID,ShopperID,orderId,houseNo,colony,city,state)
Values
('a001','s001','o001','p1','Shastri Nagar','Jaipur','Rajasthan'),
('a002','s001','o002','p2','Malviya nagar','Jaipur','rajasthan'),
('a003','s002','o003','p45','Jagatpura','Jaipur','rajasthan'),
('a004','s003','o004','p48','Tonk Phatak', 'Jaipur','rajasthan'),
('a005','s003','o005','p4','Raja Park ','Jaipur','rajasthan'),
('a006','s004','o006','p6','Shastri Nagar' ,'Jaipur','rajasthan');



select * from address;




INSERT INTO orders(OrderID,OrderStatus,Date,AddressId,ShopperID,amount)
VALUES
('o001','cancelled','2019-07-13','a001','s001','200'),
('o002','Shipped','2019-07-10','a002','s002','300'),
('o003','Returned','2019-07-3','a003','s003','350'),
('o004','Shipped','2019-08-2','a004','s004','260'),
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

select ProductID,ProductName,Price,Quantity,StockStatus,categoryName
from Products
where StockStatus=true;

SELECT products.`productname`
FROM products,Images
WHERE products.`productid` = images.`productid`;

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


