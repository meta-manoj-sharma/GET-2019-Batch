package storefront;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryClass {
	  
	   public static void main(String[] args) {
	       try
	         {
	             ConnectionClass.connectionQuery();
	             String str="s004";
	             
	             PreparedStatement statement =  ConnectionClass.connect.prepareStatement(" select orders.orderid,orders.date, sum(cart.amount * cart.quantity) as amount "
	             		+ " from orders inner join cart on "
	             		+ " orders.orderid = cart.orderid "+ " where cart.itemshippingStatus = 'shipped' and orders.userid='"+str+"' group by orders.orderid order by orders.date asc ");/*write query inside of prepared statement*/
	             PreparedStatement statement1 =  ConnectionClass.connect.prepareStatement(" select parentcategorytitle , count(categoryname) as count from category where parentcategorytitle in( select categoryname  from category where parentcategorytitle = 'Topcategory')group by parentcategorytitle; ");/*write query inside of prepared statement*/
	             PreparedStatement statement2 =  ConnectionClass.connect.prepareStatement(" select orders.orderid,orders.date, sum(cart.amount * cart.quantity) as amount "
		             		+ " from orders inner join cart on "
		             		+ " orders.orderid = cart.orderid "+ " where cart.itemshippingStatus = 'shipped' and orders.userid='"+str+"' group by orders.orderid order by orders.date asc ");/*write query inside of prepared statement*/
		            
	             ResultSet result = statement1.executeQuery();
	             System.out.println("DataBase table accessed");
	             System.out.println("Id \t" + "Date \t" + "Amount");
	             while(result.next())
	             {
	                String retrievedId= result.getString("parentcategorytitle");
	                String retrievedDate= result.getString("count");
	              //  String retrievedAmount= result.getString("amount");
	                
	                System.out.print(retrievedId+" ");
	                System.out.print(retrievedDate+" ");
	               // System.out.println(retrievedAmount);
	             }


	             ConnectionClass.connect.close();//Closing the connection
	         }

	         catch(Exception e)
	         {
	             e.printStackTrace();
	             System.out.println(e.getMessage().toString());
	         }
	   }

}
