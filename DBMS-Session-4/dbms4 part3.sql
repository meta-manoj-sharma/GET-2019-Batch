/*Part-3(a)*/
create index orderIndex on orders(userID);
SHOW INDEX FROM orders;
explain select orderID from orders where userID='s004';

/*Part-3(b)*/
explain select productID from products where productname='MonteCarle T-shirt';
create index productIndex on products(productname);
SHOW INDEX FROM products;
explain select productID from products where productname='MonteCarle T-shirt';

/*Part-3(c)*/
/*alter table category
drop index nameIndex*/
explain select ParentCategoryTitle from category where CategoryName='Shirt';
create index nameIndex on category(categoryName);
SHOW INDEX FROM category;
explain select ParentCategoryTitle from category where CategoryName='Shirt';