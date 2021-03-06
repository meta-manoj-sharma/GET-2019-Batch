use store;

/*Part-2(a)*/

 DELIMITER //
 CREATE PROCEDURE getAverageSales(in month_f int,in year_f int)
   BEGIN
   select avg(cart.amount*cart.quantity) as averagesales
from cart
inner join orders on
orders.orderid=cart.orderid
where month(orders.date)=month_f and year(orders.date)=year_f
group by cart.productid;
   END //
 DELIMITER ;


call getAverageSales('8','2019');/* calling*/






/*Part-2(b)*/

drop procedure getOrderStatus;
DELIMITER //
 CREATE PROCEDURE getOrderStatus(in startDate date,in endDate date)
BEGIN
if(startDate>endDate) then
SET startDate= DATE_ADD(DATE_ADD(LAST_DAY(endDate),INTERVAL 1 DAY),INTERVAL - 1 MONTH);/* Put startdate as 1st day of month if its greater than end date*/
end if;
select orders.date,orders.orderid,cart.itemid,cart.itemshippingstatus
from cart 
inner join orders on
orders.orderid=cart.orderid
where orders.date>=startDate and orders.date<=endDate;
   END //
 DELIMITER ;


call getOrderStatus('2019-07-12','2019-07-27');/*Calling */
