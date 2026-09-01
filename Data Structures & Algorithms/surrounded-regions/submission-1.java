class Solution {
    private static final int[] dirs = new int[] {1, 0, -1, 0, 1};

    private int ROWS;
    private int COLS;

    public void solve(char[][] board) {
        this.ROWS = board.length;
        this.COLS = board[0].length;
        HashSet<String> visited = new HashSet<>();

        // First and Last column
        for (int x = 0; x < ROWS; x++) {
            if(board[x][0] == 'O')
                dfs(board, x, 0);
            if(board[x][COLS - 1] == 'O')
                dfs(board, x, COLS - 1);
        }

        // First and Last row
        for (int y = 0; y < COLS; y++) {
            if(board[0][y] == 'O')
                dfs(board, 0, y);
            if(board[ROWS - 1][y] == 'O')
                dfs(board, ROWS - 1, y);
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Z')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (!inBound(x, y) || board[x][y] != 'O')
            return;

        board[x][y] = 'Z';
        for (int i = 0; i < dirs.length - 1; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            dfs(board, nx, ny);
        }
    }

    private boolean inBound(int x, int y) {
        return x >= 0 && y >= 0 && x < ROWS && y < COLS;
    }
}

// DFS
/*
    change all 'O' to 'Z'
    DFS again on neighbours
    neighbours are vertical and horizontal
    check bounds and visited
*/

// m = ROWS
// n = COLS
// DFS i = 0 ,  j = [0, n)
// DFS i = [0, m) , j = 0
// DFS i = m - 1, j = [0, n)
// DFS i = [0, m), j = n - 1