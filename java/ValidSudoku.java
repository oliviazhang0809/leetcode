import java.util.Arrays;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		boolean[] visited = new boolean[9];
		// row
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!process(visited, board[i][j])) {
					return false;
				}
			}
		}

		// col
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!process(visited, board[j][i])) {
					return false;
				}
			}
		}

		// submatrix
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(visited, false);
				for (int k = 0; k < 9; k++) {
					if (!process(visited, board[i + k / 3][j + k % 3])) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private static boolean process(boolean[] visited, char c) {
		if (c == '.') {
			return true;
		}
		int num = c - '0';
		if (num <= 0 || num > 9 || visited[num - 1]) {
			return false;
		}

		visited[num - 1] = true;
		return true;
	}
}
