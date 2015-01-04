public class Excel_Sheet_Column_Title {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(convertToTitle(i));
		}
	}

	public static String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		int m = 0;
		while (n > 0) {
			m = n % 26;
			if (m == 0) {
				m = 26;
			}
			sb.append((char) ('A' + m - 1));
			n = (n - m) / 26;
		}
		return sb.reverse().toString();
	}
}
