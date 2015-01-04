import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Anagrams {
	public static void main(String[] args) {
		String[] strs = { "abc", "bac", "acb", "def", "fde", "ijk" };

		ArrayList<String> test = anagrams(strs);
		System.out.println(test);

	}

	public static ArrayList<String> anagrams(String[] strs) {
		TreeMap<String, ArrayList<String>> anaHashMap = new TreeMap<String, ArrayList<String>>();
		for (String string : strs) {
			String key = getHash(string); // hashkey

			if (anaHashMap.containsKey(key)) { // if contains key, add
												// value to the
												// arraylist
				anaHashMap.get(key).add(string);
			} else { // if not contains key, add an arraylist and current string
						// with the hash key
				ArrayList<String> newArrayList = new ArrayList<String>();
				newArrayList.add(string);
				anaHashMap.put(key, newArrayList);
			}
		}

		ArrayList<String> resultList = new ArrayList<String>();
		for (ArrayList<String> strList : anaHashMap.values()) {
			resultList.addAll(0, strList);
			// add at the front because the
			// latter the character is, the
			// smaller the key is
			// e.g. z = [0,0,0.....1] but a = [1,0,0,0,0..]
		}

		return resultList;
	}

	private static String getHash(String str) {
		char[] char_array = str.toCharArray();
		int[] char_cnt = new int[26];
		for (char c : char_array) {
			char_cnt[c - 'a'] += 1;
		}
		return Arrays.toString(char_cnt);
	}
}
