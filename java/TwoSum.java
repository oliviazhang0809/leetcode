import java.util.HashMap;
/**
* Given an array of integers, find two numbers such that they add up to a specific target number.
*/
public class TwoSum {
	
	public static void main(String[] args) {
		int[] numbers = { 0, 4, 3, 0 };
		int[] out = twoSum(numbers, 0);
		for (int i : out) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length < 2) {
			return null;
		}
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		// put all numbers in array into a hashmap key: number, value: index
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}

		for (int i = 0; i < numbers.length; i++) {
			// see if sum can be found
			if (map.containsKey(target - numbers[i])) {
				int index1 = i + 1;
				int index2 = map.get(target - numbers[i]);
				// they cannot be same number
				if (index1 != index2) {
					res[0] = index1;
					res[1] = index2;
					return res;
				}
			}
		}
		return res;
	}
}
