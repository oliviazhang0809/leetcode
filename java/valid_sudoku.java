public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        boolean[] visited = new boolean[9];
        // check row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false); // start a new row
            for (int j = 0; j < 9; j++) {
                if (!process(visited, board[i][j])) return false;
            }
        }
        // check col
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false); // start a new col
            for (int j = 0; j < 9; j++) {
                if (!process(visited, board[j][i])) return false;
            }
        }
        // check submetrics
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) { // starting point
                Arrays.fill(visited, false); // start a new metrics
                for (int k = 0; k < 9; k++) {
                    if (!process(visited, board[i + k / 3][j + k % 3])) return false; // k % 3, k / 3 can switch
                }
            }
        }
        
        return true;
    }
    
    public boolean process(boolean[] visited, char c) {
        if (c == '.') return true;
        int num = c - '0';
        if (num <= 9 && num >= 1 && !visited[num - 1]) {
            visited[num - 1] = true;
            return true;
        } else {
            return false;
        }
    }
}