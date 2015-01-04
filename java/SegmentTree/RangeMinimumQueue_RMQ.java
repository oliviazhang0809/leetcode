package SegmentTree;

public class RangeMinimumQueue_RMQ {
	public static int[] constructRMQ(int[] arr) {
		double log2base = Math.log(arr.length) / Math.log(2);
		int x = (int) Math.ceil(log2base);
		int maxSize = 2 * (int) Math.pow(2, x) - 1;
		int[] rmq = new int[maxSize];
		constructUtil(arr, 0, arr.length - 1, rmq, 0);
		return rmq;
	}

	private static int constructUtil(int[] arr, int ss, int se, int[] rmq, int i) {
		if (ss == se) {
			rmq[i] = arr[ss];
			return arr[ss];
		}

		int mid = ss + (se - ss) / 2;
		rmq[i] = Math.min(constructUtil(arr, ss, mid, rmq, i * 2 + 1),
				constructUtil(arr, mid + 1, se, rmq, i * 2 + 2));
		return rmq[i];
	}

	public static int getRangeMin(int[] rmq, int n, int qs, int qe) {
		if (qs < 0 | qe > n - 1 || qs > qe) {
			System.out.println("Invalid input");
			return -1;
		}

		return getRangeMinUtil(rmq, 0, n - 1, qs, qe, 0);
	}

	private static int getRangeMinUtil(int[] rmq, int ss, int se, int qs,
			int qe, int i) {
		// if query range is bigger return current min
		if (qs <= ss && qe >= se) {
			return rmq[i];
		}

		// if completely not related
		if (qs > se || qe < ss) {
			return Integer.MAX_VALUE;
		}

		int mid = ss + (se - ss) / 2;
		return Math.min(getRangeMinUtil(rmq, ss, mid, qs, qe, i * 2 + 1),
				getRangeMinUtil(rmq, mid + 1, se, qs, qe, i * 2 + 2));
	}

	public static void main(String[] args) {
		int[] arr = { 2, 5, 1, 4, 9, 3 };
		int[] rmq = constructRMQ(arr);
		print(rmq);
		System.out.println(getRangeMin(rmq, arr.length, 3, 5));

	}

	private static void print(int[] rmq) {
		for (int i : rmq) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
