class Solution {
    class Cell {
        int row, col, cost;
        public Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = m * n;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new Cell(0,0,0));
        while (!pq.isEmpty()) {
            Cell poll = pq.poll();
            int row = poll.row, col = poll.col, cost = poll.cost;
            visited[row][col] = true;
            if (row == m - 1 && col == n - 1) {
                res = Math.min(res, cost);
                continue;
            }
            if (row + 1 < m && !visited[row + 1][col])
                pq.add(new Cell(row + 1, col, cost + (grid[row][col] == 3 ? 0 : 1)));
            if (row - 1 >= 0 && !visited[row - 1][col])
                pq.add(new Cell(row - 1, col, cost + (grid[row][col] == 4 ? 0 : 1)));
            if (col - 1 >= 0 && !visited[row][col - 1])
                pq.add(new Cell(row, col - 1, cost + (grid[row][col] == 2 ? 0 : 1)));
            if (col + 1 < n && !visited[row][col + 1])
                pq.add(new Cell(row, col + 1, cost + (grid[row][col] == 1 ? 0 : 1)));
        }

        return res;
    }
}