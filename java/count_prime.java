public class Solution {
	public int countPrime(int n) {
		if (n < 2) {
			return 0; // there is not prime
		}
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++) {
			primes[i] = true;
		}
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				for (int j = i + i;  j < n; j += i) {
					primes[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (primes[i]) {
				count++;
			}
		}
		return count;
	}
}