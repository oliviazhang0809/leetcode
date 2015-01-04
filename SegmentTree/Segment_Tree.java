package SegmentTree;

public class Segment_Tree {

	// ########### get segment sum using the segment tree ###########
	public static int getSum(int[] st, int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid input");
			return -1;
		}

		return getSumUtil(st, 0, n - 1, qs, qe, 0);
	}

	/**
	 * a recursive function to get the sum of value in given range of the array
	 * 
	 * @param st
	 *            :Pointer to segment tree
	 * @param ss
	 *            starting index of segment represented by current node, i.e.
	 *            st[index]
	 * @param se
	 *            ending index of segment represented by current node, i.e.
	 *            st[index]
	 * @param qs
	 *            : starting index of query range
	 * @param qe
	 *            :ending index of query range
	 * @param index
	 *            :Index of current node in the segment tree
	 * @return
	 */
	public static int getSumUtil(int[] st, int ss, int se, int qs, int qe,
			int index) {
		if (qs <= ss && qe >= se) {
			return st[index]; // segment is part of given range
		}

		if (se < qs || ss > qe) {
			return 0;
		}

		// if a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return getSumUtil(st, ss, mid, qs, qe, 2 * index + 1)
				+ getSumUtil(st, mid + 1, se, qs, qe, 2 * index + 2);
	}

	private static int getMid(int ss, int se) {
		return ss + (se - ss) / 2;
	}

	// ########### construct the segment tree ###########
	/**
	 * construct the segment tree integer array
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] constructST(int[] arr) {
		double log2base = Math.log(arr.length) / Math.log(2);
		int x = (int) (Math.ceil(log2base));
		int maxSize = 2 * (int) Math.pow(2, x) - 1;
		int[] st = new int[maxSize];
		constructSTUtil(arr, 0, arr.length - 1, st, 0);
		return st;
	}

	private static int constructSTUtil(int[] arr, int ss, int se, int[] st,
			int si) {

		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, st, si * 2 + 1)
				+ constructSTUtil(arr, mid + 1, se, st, si * 2 + 2);
		return st[si];
	}

	// ########### update the segment tree ###########
	// public void updateValue(int[] arr, int[] )

	/**
	 * main function
	 */

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -4, -2, 6, 7 };
		int[] res = constructST(arr);
		print(res);
		System.out.println(getSum(res, arr.length, 0, 4));

	}

	private static void print(int[] res) {
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();

	}
}
