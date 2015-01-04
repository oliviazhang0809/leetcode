public class ValidNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("e10"));

	}

	public static boolean isNumber(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		s = s.trim();
		if (s.length() == 0) {
			return false;
		}

		boolean dot = false;
		boolean e = false;

		for (int i = 0; i < s.length(); i++) {
			boolean isDigit = s.charAt(i) >= '0' && s.charAt(i) <= '9';
			if (!isDigit) {
				if (dot || e || s.charAt(i) == ' ') {
					return false;
				}

				if (s.charAt(i) == '.') {
					dot = true;
				}

				else if (s.charAt(i) == 'e') {
					if (i == 0 || i == s.length() - 1) {
						return false;
					} else {
						e = true;
					}
				}

				else if (Character.isAlphabetic(s.charAt(i))) {
					return false;
				}
			}
		}

		return true;

	}
}
