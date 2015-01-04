package Trie;

import java.util.ArrayList;

/**
 * http://blog.csdn.net/beiyeqingteng/article/details/6981263
 * 
 * @author oliviazhang
 * 
 */
public class Trie {
	private Node root;

	public Trie() {
		root = new Node(' ');
	}

	public void insert(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.subNode(c) == null) {
				current.childlist.add(new Node(c));
			}

			current = current.subNode(c);
			current.count++;
		}

		current.isEnd = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.subNode(word.charAt(i)) == null) {
				return false;
			} else {
				current = current.subNode(word.charAt(i));
			}
		}

		return current.isEnd;
	}

	public Node findSubRootNode(String base) {
		Node current = root;
		if (base == null) {
			return current;
		}

		for (int i = 0; i < base.length(); i++) {
			char c = base.charAt(i);
			current = current.subNode(c);
		}

		return current;
	}

	public void process(ArrayList<String> list, Node parent, String word,
			String prefix) {
		if (parent != null) {
			word = word + parent.content;
			if (parent.isEnd) {
				word = prefix + word;
				list.add(word);
			}

			for (int i = 0; i < parent.childlist.size(); i++) {
				process(list, parent.childlist.get(i), word, prefix);
			}
		}

	}

	public void getWords(ArrayList<String> res, String base) {
		Node parent = findSubRootNode(base);
		for (int i = 0; i < parent.childlist.size(); i++) {
			process(res, parent.childlist.get(i), "", base);
		}
	}
}
