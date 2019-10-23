/*
 * Controller for RestApi
 */
package Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.itemsDao;
import model.Item;

@Path("/items")
public class RestController {

	/**
	 * Gets All Items
	 * @return list ofitems as json
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getItems(){
		List<Item> items = itemsDao.getAllItems(); 
		return items;
	}
}
