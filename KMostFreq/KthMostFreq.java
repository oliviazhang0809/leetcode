package KMostFreq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KthMostFreq {
	private static class MutableCounter {
		int i = 1; // origin value is 1
	}

	HashMap<String, MutableCounter> map = new HashMap<String, MutableCounter>();
	ArrayList<Set<String>> list;
	Queue<String> q;
	int w, k;

	public KthMostFreq(int window, int k) {
		this.w = window;
		this.k = k;
		list = new ArrayList<Set<String>>();
		q = new LinkedList<String>();
	}

	public void insert(String word) {
		if (q.contains(word)) {
			q.remove(word);
		}

		q.offer(word); // add to last
		MutableCounter counter = map.get(word);

		if (counter == null) { // no such word
			counter = new MutableCounter();
			map.put(word, counter);
		} else {
			Set<String> strings = list.get(counter.i);
			strings.remove(word); // remove word from current bucket
			counter.i++;
		}
		// add word to the right bucket
		addToRightPos(counter.i, word);

		if (q.size() > w) { // can use if since only 1 word added
			String current = q.poll();
			MutableCounter counter1 = map.get(current);
			Set<String> strings = list.get(counter1.i);
			strings.remove(current);
		}

	}

	public ArrayList<String> getKmostWords() {
		ArrayList<String> res = new ArrayList<String>();
		int count = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			Set<String> strings = list.get(i);
			for (String s : strings) {
				res.add(s);
				count++;
				if (count == k) {
					return res;
				}
			}
		}

		return res;
	}

	private void addToRightPos(int count, String word) {
		while (count >= list.size()) {
			list.add(new HashSet<String>());
		}

		Set<String> strings = list.get(count);
		strings.add(word);
	}
}
