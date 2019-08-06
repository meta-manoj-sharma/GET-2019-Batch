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
	@Test
	public void addSuccessTest() throws Exception {

		String value = new String();
		FileReader file = new FileReader("C:/manoj/GETSample/PF/assignment 2019/Dictionary/src/dictionary/input.json.txt");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		Dictionary dictionary = new DictionaryImp(json);

		value = dictionary.getValue("20");
		assertEquals(value, "twenty");
		value = dictionary.getValue("40");
		assertEquals(value, "fourty");
		value = dictionary.getValue("50");
		assertEquals(value, "fifty");
	}

	/**
	 * delete key and value success case
	 * @throws Exception
	 */
	@Test
	public void deleteSuccessTest() throws Exception {

		FileReader file = new FileReader("C:/manoj/GETSample/PF/assignment 2019/Dictionary/src/dictionary/input.json.txt");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(file);
		DictionaryImp dictionary = new DictionaryImp(json);

		List<Value> expected = new ArrayList<Value>();
		expected.add(new Value("20", "twenty"));
		expected.add(new Value("40", "fourty"));
		expected.add(new Value("50", "fifty"));
		boolean result = dictionary.delete("20");
		assertTrue(result);
	}

	/**
	 * method to check null value case for adding
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void nullValueTest() throws Exception {
		Dictionary dictionary = new DictionaryImp();
		dictionary.add(null, "value");
	}

	/**
	 * method to check null key case for adding
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void nullKeyTest() throws Exception {
		Dictionary dictionary = new DictionaryImp();
		dictionary.add("key", null);
	}
}
