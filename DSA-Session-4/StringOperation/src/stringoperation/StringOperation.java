package stringoperation;

import java.util.*;

public class StringOperation {
	// contain word with value if unique char
	HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public int uniqueChar(String string) {
		int count = 0;
		// return if found same string for cache purpose
		if (cache.containsKey(string)) {
			count = cache.get(string);
			System.out.println("get from cache memory" + count);
			return count;
		}

		HashMap<Character, Integer> uniquechar = new HashMap<Character, Integer>();

		// iterate while string length
		for (int index = 0; index < string.length(); index++) {
			char element = (char) string.charAt(index);
			if (uniquechar.containsKey(element)) {
				int value = uniquechar.get(element);
				uniquechar.put(element, value + 1);
			} else
				uniquechar.put(element, 1);
		}

		for (Character element : uniquechar.keySet()) {
			if (uniquechar.get(element) == 1) {
				count++;
			}
		}
		cache.put(string, count);
		return count;
	}
}
