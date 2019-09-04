package com.metacube.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.json.JsonValue;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.metacube.demo.model.Element;
import com.metacube.demo.service.Service;
/**
 * 
 * @author Manoj Sharma
 * @since Sept 4, 2019
 * This is Controller class for API handing various type of requests
 */
@Path("/inventory")
public class API {

	/**
	 * This function returns all elements in JSOn format
	 * @return List<Elements> in JSON Array
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Element>  getAllElements(){
		return Service.getInstance().getElements();
	}

	/**
	 * This function returns specific element contains requested name
	 * @param name Element Name string name
	 * @return Element in JSON format
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public Element  getElements(@PathParam("name") String name){
		//addElements();
		List<Element> elements = Service.getInstance().getElements();
		Element result = new Element();
		for(Element element : elements){
			if(element.getName().equals(name)){
				result = element;
			}
		}
		return result;
	}

	/**
	 * This function is used to insert a Element into Records
	 * @param element ELement Object in JSON Format
	 * @return String as message
	 */
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addSingleElement(Element element) {
		Service.getInstance().addElement(element);
        String result = element.getName()+" Saved";
        //return Response.status(201).entity(result).build();
        return result;
    }
	
	/**
	 *  This function is used to insert a JASON Array Objects 
	 * @param element JSON Array
	 * @return String message
	 */
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Path("/addAll")
    public String addElements(String element) {
		Gson gson=new Gson();
		TypeToken<List<Element>> token = new TypeToken<List<Element>>() {};
		List<Element> elements = gson.fromJson(element, token.getType());
		String inserted="";
		for(Element e: elements){
			Service.getInstance().addElement(e);
			inserted += e.getName()+" Saved\n";
		}
        //return Response.status(201).entity(inserted).build();
		return inserted;
    }
	
	/**
	 * this Function is used to delete elements from records, this will remove all records
	 * @return String as message
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAllElements(){
		List<Element> elements = Service.getInstance().getElements();
		String result="";
		for(Element element: elements){
			result += Service.getInstance().deleteElement(element)+" Deleted \n";
		}
		return result;
	}
	
	/**
	 * This function is used to delete a specific element
	 * @param name element name
	 * @return String as message
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{element}")
	public String deleteElement(@PathParam("element") String name){
		List<Element> elements = Service.getInstance().getElements();
		String result="";
		for(Element element : elements){
			if(element.getName().equals(name)){
				result += Service.getInstance().deleteElement(element)+" Deleted \n";
			}
		}
		return result;
	}
	
	/**
	 * This Function is to update elements quantity using it's name
	 * @param name String element name
	 * @param element JSON Object of elements with updated quantity
	 * @return String message
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{name}")
	public String  updateQantity(@PathParam("name") String name, Element element){
		List<Element> elements = Service.getInstance().getElements();
		String result="";
		for(Element current: elements){
			if(current.getName().equals(name)){
				current.setQuantity(element.getQuantity());
				result = "Updated Succesfully";
			}else{
				result = "Error Occured";
			}
		}
		return result;
	}
}
