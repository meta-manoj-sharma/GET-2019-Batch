package com.metacube.demo.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.metacube.demo.model.Element;
/**
 * This is service class for operations
 * This is Singleton class to prevent for duplicate objects and Maintain List Of Elemets 
 * @author Manoj Sharma
 * @since Sept 4, 2019
 */
public class Service {
	private static Service singleInstance = null; 
	private static List<Element> elements;
   
    private Service() 
    { 
		 elements = new CopyOnWriteArrayList<Element>();
    } 
 
    public static Service getInstance() 
    { 
        if (singleInstance == null) {
        	singleInstance = new Service(); 
        }
        return singleInstance; 
    } 
    
    public static boolean addElement(Element element){
    	elements.add(element);
    	return true;
    }
    
    public static List<Element> getElements(){
    	return elements;
    }
    public static String deleteElement(Element element){
    	String name = element.getName();
    	elements.remove(element);
    	return name+" Deleted Successfully ";
    }  
}
