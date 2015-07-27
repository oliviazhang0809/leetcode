// O(N)
public static void wiggle(int[] nums) {
	if (nums == null || nums.length == 0) {
		return;
	}
	boolean decrease = true;
	int current = nums[0];
	for (int i = 0; i < nums.length - 1; i++) {
		if ((decrease && current > nums[i + 1])
				|| (!decrease && current < nums[i + 1])) {
			nums[i] = nums[i + 1];
		} else {
			nums[i] = current;
			current = nums[i + 1];
		}
		decrease = !decrease;
	}
	nums[nums.length - 1] = current;
}


// O(Nlong(N))
public static void wiggleSort(int[] nums) {
	if (nums == null || nums.length == 0) {
		return;
	}
	Arrays.sort(nums);
	int index = 0;
	while (index < nums.length - 1) {
		swap(nums, index, index + 1);
		index += 2;
	}
}

public static void swap(int[] arr, int i, int j) {
	int tmp = arr[i];
	arr[i] = arr[j];
	arr[j] = tmp;
}