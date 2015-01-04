package Trie;

import java.util.ArrayList;

public class PrefixSearch {

	public static void main(String[] args) {
		Trie dict = new Trie();
		String[] strs = { "asdf", "asdg", "asef", "bdfga", "bas" };
		String base = "as"; // should return [asdf, asdg, asef]

		for (String str : strs) {
			dict.insert(str);
		}

		ArrayList<String> res = new ArrayList<String>();
		dict.getWords(res, base);
		System.out.println(res);

	}
}
