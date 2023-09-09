class Solution {
    public int shortestPath(int[][] grid, int k) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,0,k}); // row, col, steps, k_left
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0], col = p[1], steps = p[2], kLeft = p[3];
            if (row == m - 1 && col == n - 1) {
                return steps;
            }
            for (int[] dir: dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                    if (grid[nextRow][nextCol] == 1 && kLeft > 0 && !visited[nextRow][nextCol][kLeft - 1]) {
                        visited[nextRow][nextCol][kLeft - 1] = true;
                        queue.add(new int[]{nextRow, nextCol, steps + 1, kLeft - 1});
                    }
                    else if (grid[nextRow][nextCol] == 0 && !visited[nextRow][nextCol][kLeft]) {                    
                        visited[nextRow][nextCol][kLeft] = true;
                        queue.add(new int[]{nextRow, nextCol, steps + 1, kLeft});
                    }
                }
            }
        }

        return -1;
    }
}