public class LongestPalindromeSubstr {
	public static void main(String[] args) {
		String s = "abcdeedc";
		String out = longestPalinSubstring(s);
		System.out.println(out);
	}

	// shorter version

	public static String longestPalinSubstring(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int length = s.length();
		int max = 0;
		String res = "";

		for (int i = 1; i <= 2 * length - 1; i++) {
			int count = 1;
			while (i - count >= 0 && i + count <= 2 * length
					&& get(s, i - count) == get(s, i + count)) {
				count++;
			}
			count--; // one extra count
			if (count > max) {
				res = s.substring((i - count) / 2, (i + count) / 2);
				max = count;
			}
		}
		return res;
	}

	public static int get(String s, int i) {
		if (i % 2 == 0) {
			return '#';
		} else {
			return s.charAt(i / 2);
		}
	}

	// number 2 way
	public static String expandFromCenter(String s, int start, int end) {
		while (start >= 0 && end < s.length()
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}

		String longest = s.substring(0, 1);
		String tmp;
		for (int i = 0; i < s.length() - 1; i++) {
			tmp = expandFromCenter(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
			tmp = expandFromCenter(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
		return longest;
	}
}
