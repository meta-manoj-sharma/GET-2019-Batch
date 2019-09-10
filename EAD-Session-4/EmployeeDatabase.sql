drop database employee;
create database employee;
use employee;
create table employeeData(

employeeId int primary key Auto_Increment,
			
Name varchar(50) NOT NULL,

gender varchar(20)  NOT NULL,

password varchar(40)  NOT NULL,

Email varchar(40) UNIQUE NOT NULL,

contactNumber varchar(20) NOT NULL,
		
organization varchar(50) NOT NULL
			
);
create table vehicle(

Name varchar(50) NOT NULL,

Type varchar(20)  NOT NULL,

Number Int NOT NULL,

employeeId int NOT NULL,
		
identification varchar(255)  NOT NULL,

primary key(Number),

FOREIGN KEY (employeeId) references employeeData (employeeId)

);

create table setPass(
Number Int NOT NULL,

Type varchar(20)  NOT NULL,

priceInUSD varchar(20) NOT NULL,

PlanType varchar(20) NOT NULL,
		
FOREIGN KEY (Number) references vehicle (Number)

);
set foreign_key_checks=0;
SET SQL_SAFE_UPDATES=0;
INSERT INTO vehicle(Name, Type, Number, employeeId, identification) VALUES('alto','car','2356','12','car');
select * from employeeData where email != 'wrew@gmail.com' and
organization in (select organization from employeeData where email = 'wrew@gmail.com');












select user.userID,user.name ,user.phone,user.email,
orders.orderid, sum(cart.Amount*cart.Quantity) as Amount

from orders

left join user on

user.userID=orders.userID

inner join cart on

orders.OrderID=cart.OrderID

where cart.itemshippingstatus='shipped' AND  DATEDIFF(CURRENT_DATE(),orders.Date)<30
and user.usertype != 'admin'

group by orders.userID

order by amount desc

limit 10;

