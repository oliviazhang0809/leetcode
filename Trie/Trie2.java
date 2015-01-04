package Trie;

import java.util.ArrayList;

public class Trie2 {
	public class Node {
		char content;
		boolean isEnd;
		Node[] childlist;

		Node(char c) {
			content = c;
			isEnd = false;
			childlist = new Node[128];
		}
	}

	private Node root;

	public Trie2() {
		root = new Node(' ');
	}

	public void insert(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (current.childlist[c] == null) {
				current.childlist[c] = new Node(c);
			}
			current = current.childlist[c];
		}

		current.isEnd = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			current = current.childlist[c];
			if (current == null) {
				return false;
			}
		}

		return current.isEnd;
	}

	public void getWords(ArrayList<String> list) { // fill in the list
		for (int i = 0; i < root.childlist.length; i++) {
			process(list, root.childlist[i], "");
		}
	}

	private void process(ArrayList<String> list, Node parent, String word) {
		if (parent != null) {
			word = word + parent.content;
			if (parent.isEnd) {
				list.add(word);
			}

			for (int i = 0; i < parent.childlist.length; i++) {
				process(list, parent.childlist[i], word);
			}
		}
	}

	public Node getRoot() {
		return root;
	}
}
