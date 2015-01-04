public class LongestCommonSub {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("XMJYAUZ", "MZJAWXU"));
		// return
		// MJAU
		System.out.println(longestCommonSubsequence("FABCDXK", "DBQCPDJX"));
		// return
		// BCDX
		System.out.println(longestCommonSubsequence("12358", "43581")); // return
																		// 358
	}

	public static String longestCommonSubsequence(String s1, String s2) {
		// check null
		if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
			return "";
		}

		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j))
					dp[i][j] = dp[i + 1][j + 1] + 1;
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		// print(dp);

		StringBuilder sb = new StringBuilder();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (s1.charAt(i) == s2.charAt(j)) {
				sb.append(s1.charAt(i)); // cross the bridge
				i++;
				j++;
			} else if (dp[i + 1][j] >= dp[i][j + 1]) { // towards larger side
				i++;
			} else {
				j++;
			}
		}

		return sb.toString();
	}

	/**
	 * logistic print
	 */

	public static void print(int[][] m) {
		for (int[] arr : m) {
			for (int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
