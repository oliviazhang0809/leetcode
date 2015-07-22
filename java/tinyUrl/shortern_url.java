public class UrlShortener {

	public static void main(String[] args) {
		System.out.println(encode(200233));
		System.out.println(decode("0fJ"));

	}

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int BASE = ALPHABET.length();

	public static String encode(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(ALPHABET.charAt(num % BASE)); // find the char digit
			num /= BASE;
		}
		return sb.reverse().toString();
	}

	public static int decode(String str) {
		int num = 0;
		for (int i = 0, len = str.length(); i < len; i++) {
			num = num * BASE + ALPHABET.indexOf(str.charAt(i)); // find the char index
		}
		return num;
	}
}
