import java.util.LinkedList;
import java.util.Queue;

public class InPlaceShuffle {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 100, 101, 102, 103, 104 };
		change(arr, 5);
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private static void change(int[] arr, int bn) {
		int index = 1;
		Queue<Integer> q = new LinkedList<Integer>();

		while (bn < arr.length) {
			q.offer(arr[index]);
			if (index % 2 != 0) {
				arr[index] = arr[bn++];
			} else {
				arr[index] = q.poll();
			}
			index++;
		}
	}
}
