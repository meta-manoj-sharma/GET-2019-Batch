package stringoperation;

import java.util.*;

public class StringOperation {
	// contain word with value if unique char
	HashMap<String, Integer> cacheMap = new HashMap<String, Integer>();

	public int uniqueChar(String string) {
		int count = 0;
		// return if found same string for cache purpose
		if (cacheMap.containsKey(string)) {
			count = cacheMap.get(string);
			System.out.println("get from cache memory" + count);
			return count;
		}

		Set<Character> uniquechar = new HashSet<Character>();

		if (!cacheMap.containsKey(string)) {
			for (int i = 0; i < string.length(); i++) {
				uniquechar.add(string.charAt(i));
			}
			cacheMap.put(string, uniquechar.size());
			count = uniquechar.size();
		}
		return count;
	}
}
