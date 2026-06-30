class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;
        int r = 0, c = n - 1;

        while(r < m && c >= 0) {
            if(matrix[r][c] > target) {
                c--;
            } else if(matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }

        return false;
    }
}
