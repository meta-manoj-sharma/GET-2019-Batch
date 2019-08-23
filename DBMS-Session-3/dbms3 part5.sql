use store;




/*Part-5(a)*/
create view orderview as 
select cart.itemid,cart.orderid,products.productname,products.price,user.email, 
orders.date,cart.itemshippingstatus

from cart

inner join orders on

cart.orderid=orders.orderid

inner join user on

user.userid=orders.userid

inner join products on

products.productid=cart.productid

where DATEDIFF(CURRENT_DATE(),orders.Date)<60;



select * from orderview;



/*Part-5(b)*/

select productname 

from orderview

where itemshippingstatus='shipped';

/*Part-5(c)*/

select productname,count(productname) as NoOfProductsSold

from orderview

group by productname
order by NoOfProductsSold desc

limit 5;

