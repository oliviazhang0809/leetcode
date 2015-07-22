import java.util.HashMap;
import java.util.HashSet;

public class TinyUrl {

	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		populateMap(map);
		// System.out.println(map);
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < 100000; i++) {
			String url = shorturl(i, 10, map); // base of 10 -- you can do
												// whatever
			if (set.contains(url)) {
				System.out.println(url);
			} else {
				set.add(url);
			}
		}

		// System.out.println(set.size());
	}

	public static void populateMap(HashMap<Integer, String> map) {
		char base = 'A';
		for (int i = 0; i < 58; i++) {
			map.put(i, base + "");
			base++;
		}
	}

	public static String shorturl(int id, int base, HashMap<Integer, String> map) {
		StringBuilder res = new StringBuilder();
		while (id > 0) {
			int digit = id % base;
			res.append(map.get(digit));
			id /= base;
		}
		while (res.length() < 6)
			res.append('0');
		return res.reverse().toString();
	}
}
