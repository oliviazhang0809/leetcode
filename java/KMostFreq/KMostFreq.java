package KMostFreq;

/**
 * k most frequent word in one comment
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class KMostFreq {
	private static class MutableCounter {
		int i = 1; // origin value is 1
	}

	static HashMap<String, MutableCounter> map = new HashMap<String, MutableCounter>();

	ArrayList<Set<String>> list = new ArrayList<Set<String>>();

	/**
	 * Using minHeap and maxHeap, and root to keep track of the partition point
	 * Every element in the minHeap in the right side is the k most frequent
	 * 
	 * 
	 * step1 : create two valid heaps : minHeap && maxHeap
	 * 
	 * Step2 : add k + 1 elements into to hashmap and minHeap, then poll out the
	 * root
	 * 
	 * Step3 : process the rest n - k - 1 elements, if not exists in map, add to
	 * maxHeap, else map.get(element).i++ (increase the count)
	 * 
	 * Step 4: recalculate the root using rehepify, which is to swap the max
	 * element in maxHeap or swap the min element in minHeap with root if the
	 * order is not right
	 * 
	 * 
	 */
	public static void countMostFrequentWords(String reviews, int k) {
		Queue<String> minHeap = new PriorityQueue<String>(reviews.length(),
				new Comparator<String>() {
					public int compare(String o1, String o2) {
						return map.get(o1).i - map.get(o2).i;
					}
				});

		Queue<String> maxHeap = new PriorityQueue<String>(reviews.length(),
				new Comparator<String>() {
					public int compare(String o1, String o2) {
						return map.get(o2).i - map.get(o1).i;
					}
				});

		int count = 0;
		int i;
		String[] words = reviews.split(" ");
		for (i = 0; i < words.length; i++) { // add k comments into the
												// minHeap
			String comment = words[i];
			if (!map.containsKey(comment)) {
				MutableCounter counter = new MutableCounter();
				map.put(comment, counter);
				minHeap.offer(comment);
				count++;
				if (count == k + 1) { // add one more as root
					break;
				}
			} else {
				map.get(comment).i++;
			}
		}

		String root = minHeap.poll();
		for (; i < words.length; i++) { // starting from the ith element
			String comment = words[i];
			// add to heap
			if (!map.containsKey(comment)) {
				MutableCounter counter = new MutableCounter();
				map.put(comment, counter);
				maxHeap.offer(comment); // add to maxHeap
			} else {
				MutableCounter counter = map.get(comment); // increase the count
				counter.i++;
			}

			root = reheapify(maxHeap, minHeap, root, k); // recalculate the root
		}

		System.out.println(minHeap);
	}

	private static String reheapify(Queue<String> maxHeap,
			Queue<String> minHeap, String root, int k) {
		if (maxHeap.size() > 0 && map.get(maxHeap.peek()).i > map.get(root).i) {
			maxHeap.offer(root);
			root = maxHeap.poll();
		}

		if (minHeap.size() > 0 && map.get(minHeap.peek()).i < map.get(root).i) {
			minHeap.offer(root);
			root = minHeap.poll();
		}

		return root;
	}

	/**
	 * Jason's method
	 * 
	 */

	public ArrayList<String> getKthMost(String comment, int k) {
		ArrayList<String> res = new ArrayList<String>();

		String[] words = comment.split(" ");
		for (String word : words) {
			MutableCounter count = map.get(word);
			if (count == null) {
				count = new MutableCounter();
				map.put(word, count);
			} else {
				Set<String> strings = list.get(count.i);
				strings.remove(word);
				count.i++;
			}
			addToRightPlace(word, count.i);
		}

		System.out.println(list);
		int count = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			Set<String> curr = list.get(i);
			for (String word : curr) {
				res.add(word);
				count++;
				if (count == k) {
					return res;
				}
			}
		}

		return null;

	}

	private void addToRightPlace(String word, int i) {
		while (list.size() <= i) {
			list.add(new HashSet<String>());
		}

		Set<String> curr = list.get(i);
		curr.add(word);

	}

	public static void main(String[] args) {
		String words = "This is a very good comment. An apple is what we need since it is good for human body!";
		KMostFreq.countMostFrequentWords(words, 2);

	}
}
