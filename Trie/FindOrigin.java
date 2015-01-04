package Trie;

public class FindOrigin {

	public static void main(String[] args) {
		Trie dict = new Trie();
		dict.insert("+44");
		dict.insert("+4420");
		dict.insert("+447");
		dict.insert("+44750");

		String s = "+447507439854795";
		int end = 0;

		for (int i = 1; i < s.length(); i++) {
			if (dict.search(s.substring(0, i))) {
				end = i;
			}
		}

		System.out.println(s.substring(0, end));
	}
}
