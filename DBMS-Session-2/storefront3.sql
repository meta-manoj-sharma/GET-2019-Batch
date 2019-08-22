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
where (cart.itemshippingStatus != 'shipped')
AND DATEDIFF(CURRENT_DATE(),orders.date)>10;


select user.Name
from user 
left join orders on
orders.userID=user.userID
where (orders.userID IS NULL
|| DATEDIFF(CURRENT_DATE(),orders.date)>30)
and  user.usertype != 'Admin';


select user.Name,orders.OrderID
from user
left join orders on
orders.userID=user.userID
where DATEDIFF(CURRENT_DATE(),orders.Date)>15
and  user.usertype != 'Admin';


select orders.OrderID,orders.Date
from Orders
inner join cart on
orders.OrderID=cart.OrderID
where cart.itemshippingstatus = 'shipped'
and cart.OrderID = 'o004';

select orders.OrderID,orders.date,orders.userId
from Orders
inner join cart on
orders.OrderID=cart.OrderID
where cart.Amount between '20' and '50';

