import java.util.HashSet;

public class ConvenientNeigh {
	char c;
	HashSet<Character> neighbors;

	public ConvenientNeigh(char c) {
		this.c = c;
		neighbors = new HashSet<Character>();
	}

	public void addNeighbor(char c) {
		neighbors.add(c);
	}
}
