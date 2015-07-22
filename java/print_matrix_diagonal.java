package leetcode;

public class Test1 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		print2(matrix);
		System.out.println();
		printDiag(matrix);

	}

	public static void printDiag(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		for (int curr = 1; curr <= col + row - 1; curr++) {
			int startLine = Math.max(0, curr - col);
			int count = Math.min(Math.min(curr, row - startLine), col);

			for (int j = 0; j < count; j++) {
				System.out.print(matrix[startLine + j][Math.min(col, curr) - j
						- 1]);
			}
			System.out.println();
		}
	}

	public static void print2(int[][] matrix) {
		int n = matrix.length;
		for (int line = 0; line < 2 * n - 1; line++) {
			int z = line < n ? 0 : line - n + 1;
			for (int j = z; j <= line - z; j++) {
				System.out.print(matrix[j][line - j]);
			}
			System.out.println();
		}
	}

}
