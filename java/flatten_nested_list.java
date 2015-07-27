package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestList {
	// flatten nested list
	// https://gist.github.com/seanzhu/11167427

	public static void main(String[] args) {
		String s = "[1, [2, [[3], 4]], [5, [6], 7], 8, [[9, 10]]]";
		// String s = "123";
		System.out.println(transform(s));
	}

	public static List<Object> transform(String s) {
		if (s == null || s.length() == 0) {
			return new ArrayList<Object>();
		}
		if (Character.isDigit(s.charAt(0))) {
			ArrayList<Object> res = new ArrayList<Object>();
			res.add(Integer.parseInt(s));
			return res;
		} else {
			return processArray(s);
		}
	}

	public static List<Object> processArray(String s) {
		List<Object> res = new ArrayList<Object>();
		if (s == null || s.length() == 0) {
			return res;
		}

		s = s.substring(1, s.length() - 1); // remove first and last
		List<Object> tmp = new ArrayList<Object>();
		Stack<List<Object>> stack = new Stack<List<Object>>();
		int i = 0;

		while (i < s.length()) {
			char c = s.charAt(i);
			if (c == '[') {
				stack.push(res);
				res = new ArrayList<Object>();
			} else if (c == ']') {
				tmp = res;
				res = stack.pop();
				res.add(tmp);
			} else if (Character.isDigit(c)) {
				int start = i;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					i++;
				}
				res.add(Integer.parseInt(s.substring(start, i)));
				continue;
			}
			i++;
		}
		return res;
	}

}