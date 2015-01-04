public class NextGreaterNumber {
	public static void main(String[] args) {
		String input = "534976";
		String res = nextGreaterNum(input);
		System.out.println(res);

	}

	private static String nextGreaterNum(String input) {
		char[] arr = input.toCharArray();
		int i;
		// find the first non-ascending digit from right <--
		for (i = input.length() - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) { // not ascending from right
				break;
			}
		}

		if (i == -1) { // all ascending <--
			return null;
		}

		// find the first digit greater than arr[i] <--
		int j;
		for (j = input.length() - 1; j >= i; j--) {
			if (arr[j] > arr[i]) {
				break;
			}
		}

		// swap
		swap(arr, i, j);

		// sort from index i + 1 to arr.length - 1
		quickSort(arr, i + 1, arr.length - 1);
		return new String(arr);

	}

	private static void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	private static void quickSort(char[] arr, int low, int high) {
		int i = low, j = high;
		int mid = low + (high - low) / 2;
		int pivot = arr[mid];

		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				swap(arr, i, j);
				i++;
				j--;
			}
		}

		if (low < j) {
			quickSort(arr, low, j);
		}

		if (i < high) {
			quickSort(arr, i, high);
		}
	}
}
