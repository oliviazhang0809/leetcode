package leetcode;
// determine if two strings are exactly one distance away
public class Test1 {

	public static void main(String[] args) {
		System.out.println(oneEdit("abfff", "abcfff"));
	}

	public static boolean oneEdit(String s, String t) {
		int m = s.length(), n = t.length();
		if (m > n) {
			return oneEdit(t, s);
		}
		if (n - m > 1) {
			return false;
		}
		int i = 0, shift = n - m;
		while (i < m && s.charAt(i) == t.charAt(i)) {
			i++;
		}
		System.out.println(i);
		if (i == m) {
			return shift > 0;
		}
		if (shift == 0) {
			i++;
		}
		while (i < m && s.charAt(i) == t.charAt(i + shift)) {
			i++;
		}
		return i == m;
	}

}
