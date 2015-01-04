/**
 * longest repeating substring with NO overlapping
 * 
 * e.g.banaana return ana
 * 
 * @author oliviazhang
 * 
 */
public class LongestRepeatedsubstring {

	public static void main(String[] args) {
		System.out
				.println(getLongest("1-531235621765-55533211213576-612305006432332123516563211-5511033660556306543203211212354332355565551-12332120356332160701-1-"));

	}

	public static String getLongest(String s) {
		if (s == null || s.length() == 0) {

		}

		for (int len = s.length() / 2; len >= 1; len--) { // length of substring
			for (int start = 0; start + 2 * len <= s.length(); start++) {
				// at least there is one
				// locate current string start - start + len
				for (int i = start + len; i + len <= s.length(); i++) { // substring
																		// after
																		// current
					if (s.charAt(i) == s.charAt(start) // first character equals
														// current string
							&& compare(s, start, i, len)) {
						return s.substring(start, start + len);
					}
				}
			}
		}
		return null;
	}

	private static boolean compare(String s, int i, int j, int len) {
		while (len > 0) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j++;
				len--;
			}
		}
		return true;
	}

}
