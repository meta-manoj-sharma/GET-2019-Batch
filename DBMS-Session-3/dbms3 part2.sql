use Store;



/*Part-2(a)*/

select ProductID,ProductName,count(CategoryID) as CountofCategory

from Products

group by ProductName
having count(CategoryID)>1;









/*Part-2(b)*/

SELECT ProductID as NoOfProducts,
(CASE
    WHEN Price > 500 THEN "Range (> 500)"
    
WHEN Price > 100 AND Price <= 500 THEN "Range (101-500)"
   
ELSE "Range < 100 "
    END)

FROM Products;


SELECT
    COUNT(CASE WHEN Price > 500 THEN 1 END) AS "Range (> 500)",
    
COUNT(CASE  WHEN Price > 100 AND Price <= 500 THEN 1 END) AS "Range (101-500)",
    
COUNT(CASE  WHEN Price >=0 AND Price <= 100 THEN 1 END) AS "Range (101-500)"
      
FROM Products; 








/*Part-2(c)*/

select category.CategoryName,count(products.categoryID) as NoOfProducts

from category

inner join products on 
category.CategoryID=Products.CategoryID

group by products.categoryID;
