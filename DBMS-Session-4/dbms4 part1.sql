use store;
/*Part-1(a)*/
DELIMITER //
create function noOfOrders( input_month int,input_year int) returns int deterministic
begin
declare total int;
select count(orders.orderid)
from Orders
where year(date)=input_year and month(date)= input_month into total;
return total;
end;
//
DELIMITER ;

select noOfOrders('8','2019') as totalorders;

/*Part-1(b)*/
DELIMITER //
create function monthofmaxorder(input_year int) returns int deterministic
begin
declare monthinyear int;
select checkmonth as monthinyear
from(select count(orders.orderid) as count,month(date) as checkmonth
from Orders
where year(date)=input_year 
group by month(date)
) as T
order by count desc
limit 1 into monthinyear;
return monthinyear;
end;
//
DELIMITER ;
select monthofmaxorder('2019') as  monthHavingOrder;/* calling*/