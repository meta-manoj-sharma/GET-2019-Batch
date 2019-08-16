use Store;

select orders.OrderID,orders.Date,sum(cart.Amount*cart.Quantity) as Amount
from Orders
inner join cart on
orders.OrderID=cart.OrderID
group by orders.OrderID
order by orders.date desc
limit 50;


select orders.OrderID,orders.Date,sum(cart.Amount*cart.Quantity) as Amount
from Orders
inner join cart on
orders.OrderID=cart.OrderID
group by orders.OrderID
order by Amount desc
limit 3;


select orders.OrderID
from Orders
inner join cart on
orders.OrderID=cart.OrderID
where (cart.orderStatus != 'shipped')
AND DATEDIFF(CURRENT_DATE(),orders.date)>10;


select user.userName
from user
left join shopper on
Shopper.userID=user.userID
left join orders on
orders.ShopperID=Shopper.ShopperID
where orders.ShopperID IS NULL
|| DATEDIFF(CURRENT_DATE(),orders.date)>30;


select (select user.userName
from user
where
Shopper.userID =user.userID),orders.OrderID
from Shopper
left join orders on
orders.ShopperID=Shopper.ShopperID
where DATEDIFF(CURRENT_DATE(),orders.Date)>15;


select orders.OrderID,orders.Date
from Orders
inner join cart on
orders.OrderID=cart.OrderID
where cart.orderstatus = 'shipped'
and cart.OrderID = 'o004';

select orders.OrderID,orders.date,orders.shopperId
from Orders
inner join cart on
orders.OrderID=cart.OrderID
where cart.Amount between '20' and '50';

