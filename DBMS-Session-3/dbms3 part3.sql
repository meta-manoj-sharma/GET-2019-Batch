use store;



select user.userID,user.name, user.phone,user.email,count(orders.orderID) as NoOfProducts

from user

inner join orders on

orders.userID = user.userID

where DATEDIFF(CURRENT_DATE(),orders.Date)<30
and usertype != 'Admin'

group by user.userID;







/*Part-3(b)*/


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



/*Part-3(c)*/


select (cart.productid),products.productname,count(cart.orderID) as NoOfProducts

from cart

inner join products on

products.productid=cart.productid

where itemshippingstatus='shipped'

group by productid

order by NoOfProducts desc

limit 3;





/*Part-3(d)*/

SELECT DATE_FORMAT(orders.date, "%m-%Y") AS Month,sum(cart.Amount*cart.Quantity) as MonthlySales

FROM orders

inner join cart on

orders.orderid=cart.orderid

where cart.itemshippingstatus='shipped'

GROUP BY DATE_FORMAT(orders.date, "%m-%Y") ;





/*Part-3(e)*/



SET SQL_SAFE_UPDATES = 0;


update products

left join cart on

cart.productid=products.productid

left join orders on

cart.orderid=orders.orderid

set products.isInstock=false

where cart.orderid is null
 or DATEDIFF(CURRENT_DATE(),orders.Date)<30;


select * from products;





/*Part-3(f)*/

select products.productid,products.productname 

from products
inner join category on
category.categoryid = products.categoryid

where category.categoryname like 'M%';






/*Part-3(g)*/

select products.productname,count(cart.productid) as no_of_cancellation

from products

inner join cart on

products.productid=cart.productid

where cart.itemShippingstatus='cancelled'
group by cart.productid
order by no_of_cancellation desc
limit 3;