class Solution {
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, m, n, i, j, memo));
            }
        }
        return res;
    }

    public int dfs(int[][] matrix, int m, int n, int i, int j, int[][] memo) {        
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int path = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && matrix[nextI][nextJ] > matrix[i][j])
                path = Math.max(1 + dfs(matrix, m, n, nextI, nextJ, memo), path);
        }
        memo[i][j] = path;
        return path;
    }
}