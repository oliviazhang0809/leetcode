
public class Factorial_Trailing_Zeroes {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(2147483647));

	}

	public static int trailingZeroes(int n) {
		int count = 0;
		for (int j = 5; n / j >= 1; j *= 5) {
			if (n / j == 1) {
				return (j % 5 == 0) ? count + 1 : count;
			}
			count += n / j;
		}
		return count;
	}

}
