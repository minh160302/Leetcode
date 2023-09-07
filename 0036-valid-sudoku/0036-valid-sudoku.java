class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] grids = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            grids[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int val = board[i][j] - '0';
                int gridIndex = (i/3) * 3 + j/3;
                if (rows[i].contains(val) || cols[j].contains(val) || grids[gridIndex].contains(val)) {
                    return false;
                }
                rows[i].add(val);
                cols[j].add(val);
                grids[gridIndex].add(val);
            }
        }
        return true;
    }
}