package Trie;

import java.util.ArrayList;

public class Node {
	public char content;
	public boolean isEnd;
	int count;
	ArrayList<Node> childlist;

	public Node(char c) {
		childlist = new ArrayList<Node>();
		isEnd = false;
		content = c;
		count = 0;
	}

	public Node subNode(char c) {
		if (childlist != null) {
			for (Node child : childlist) {
				if (child.content == c) {
					return child;
				}
			}
		}
		return null;
	}
}
