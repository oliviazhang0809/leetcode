import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public static void main(String[] args) {
		String s = "hit";
		String e = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");

		ArrayList<ArrayList<String>> out = findLadders(s, e, dict);
		System.out.println(out);
	}

	public static ArrayList<ArrayList<String>> findLadders(String start,
			String end, Set<String> dict) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		if (start == null || start.length() == 0 || end == null
				|| end.length() == 0) {
			return res;
		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		bfs(start, end, dict, map); // initialize map using dict
		System.out.println(map);
		ArrayList<String> list = new ArrayList<String>();
		dfs(end, start, map, res, list); // fill in res with the helper of list
		return res;
	}

	public static void dfs(String start, String end,
			HashMap<String, Integer> map, ArrayList<ArrayList<String>> res,
			ArrayList<String> list) {
		if (start.equals(end)) {
			list.add(start);
			Collections.reverse(list);
			res.add(new ArrayList<String>(list));
			return;
		}

		if (!map.containsKey(start)) { // no bright
			return;
		}

		list.add(start);
		int newdepth = map.get(start) - 1;

		for (int j = 0; j < start.length(); j++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (c != start.charAt(j)) {
					char[] arr = start.toCharArray();
					arr[j] = c;
					String tmp = new String(arr);
					if (map.containsKey(tmp) && map.get(tmp) == newdepth) {
						ArrayList<String> newlist = new ArrayList<String>(list);
						dfs(tmp, end, map, res, newlist);
					}
				}
			}
		}

	}

	public static void bfs(String start, String end, Set<String> dict,
			HashMap<String, Integer> map) {
		Queue<String> q = new LinkedList<String>();
		q.offer(start);
		map.put(start, 0);

		while (!q.isEmpty()) {
			String curr = q.poll();
			for (int j = 0; j < curr.length(); j++) {
				for (char c = 'a'; c <= 'z'; c++) {
					if (c != curr.charAt(j)) {
						// replace
						char[] arr = curr.toCharArray();
						arr[j] = c;
						String tmp = new String(arr);
						if (tmp.equals(end) || dict.contains(tmp)) {
							if (!map.containsKey(tmp)) {
								map.put(tmp, map.get(curr) + 1);
								q.offer(tmp);
							}
						}
					}
				}
			}
		}
	}
}
