public class Excel_sheet_column_number {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AA"));

	}

	public static int titleToNumber(String s) {
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			int digit = s.charAt(i) - 'A' + 1;
			res += digit * Math.pow(26, s.length() - 1 - i);
		}
		return res;
	}

}
