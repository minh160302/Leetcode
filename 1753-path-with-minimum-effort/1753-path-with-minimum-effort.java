class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int m = heights.length, n = heights[0].length;
        int[][] difference = new int[m][n];
        for (int i = 0; i < m; i++) 
            Arrays.fill(difference[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int row = p[0], col = p[1], diff = p[2];
            if (row == m-1 && col == n-1)
                return diff;
            for (int[] dir : dirs) {
                int nextRow = row + dir[0], nextCol = col + dir[1];
                if (nextRow >= 0 && nextCol >= 0 && nextRow < m && nextCol < n) {
                    int cellDiff = Math.abs(heights[nextRow][nextCol] - heights[row][col]);
                    int nextDiff = Math.max(cellDiff, diff);
                    if (difference[nextRow][nextCol] > nextDiff) {
                        difference[nextRow][nextCol] = nextDiff;
                        pq.add(new int[]{nextRow, nextCol, nextDiff});
                    }
                }
            }
        }
        return 0;
    }
}