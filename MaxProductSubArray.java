
public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] arr = { -5, 2, -3 };
		System.out.println(maxProductSubArray(arr));
		System.out.println(maxProductSubArr(arr));

	}

	public static int maxProductSubArr(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int res = arr[0], min = arr[0], max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int curr_min = Math.min(min * arr[i], max * arr[i]);
			int curr_max = Math.max(min * arr[i], max * arr[i]);
			min = Math.min(arr[i], curr_min);
			max = Math.max(arr[i], curr_max);
			res = Math.max(res, max);
		}
		return res;
	}

	public static int maxProductSubArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max_so_far = 1, min_so_far = 1, maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				max_so_far *= arr[i];
				min_so_far *= arr[i];
				maxProduct = max_so_far > maxProduct ? max_so_far : maxProduct;
			} else if (arr[i] == 0) {
				maxProduct = Math.max(0, maxProduct);
				max_so_far = 1;
				min_so_far = 1;
			} else {
				maxProduct = Math.max(min_so_far * arr[i], maxProduct);
				int tmp = max_so_far;
				max_so_far = Math.max(1, min_so_far * arr[i]);
				min_so_far = tmp * arr[i];
			}
		}
		return maxProduct;
	}

}
