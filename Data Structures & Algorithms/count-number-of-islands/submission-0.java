class Solution {
    int m = -1;
    int n = -1;
    int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    sinkIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void sinkIsland(char[][] grid, int x, int y) { 
        
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0')
            return;

        grid[x][y] = '0';
        for (int[] dir : dirs) {
            sinkIsland(grid, x + dir[0], y + dir[1]);
        }
    }

}
