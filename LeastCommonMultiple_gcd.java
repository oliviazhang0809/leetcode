public class LeastCommonMultiple_gcd {
	public static void main(String[] args) {
		int p = 8;
		int q = 10;
		System.out.println(lm(p, q));
	}

	private static int lm(int p, int q) {
		return p * q / gcd(p, q);
	}

	private static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		} else {
			return gcd(q, p % q);
		}
	}
}
