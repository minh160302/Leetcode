class Solution {
    int[][] dirs = new int [][]{{1,0},{-1,0},{0,1},{0,-1}};
    int mod = 1_000_000_007;
    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dfs(grid, m, n, i, j, memo)) % mod;
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int m, int n, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        int cnt = 1;
        for (int[] dir : dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (nextI >= 0 && nextJ >= 0 && nextI < m && nextJ < n && grid[nextI][nextJ] > grid[i][j]) {
                cnt = (cnt + dfs(grid, m, n, nextI, nextJ, memo)) % mod;
            }
        }
        memo[i][j] = cnt;
        return cnt;
    }
}