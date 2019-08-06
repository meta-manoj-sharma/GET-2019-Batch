package dictionary;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;


public class DictionaryImpTest {
	
	    /**
	     * method to check null value case for adding 
	     * @throws Exception
	     */
	    @Test(expected=NullPointerException.class)
	    public void nullValueTest() throws Exception {
	    	Dictionary dictionary = new DictionaryImp();
	    	dictionary.add(null, "value");
	    }
	    
	    /**
	     * method to check null key case for adding 
	     * @throws Exception
	     */
	    @Test(expected=NullPointerException.class)
	    public void nullKeyTest() throws Exception {
	    	Dictionary dictionary = new DictionaryImp();
	    	dictionary.add("key", null);
	    }
}
