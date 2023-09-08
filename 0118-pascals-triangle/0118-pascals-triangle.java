class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            if (i == 0) {
                res.add(row);
                continue;
            }
            row.add(1);
            if (i == 1) {
                res.add(row);
            }
            else {
                for (int j = 1; j < i; j++) {
                    int val = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
                    row.add(j, val);
                }
                res.add(row);
            }
        }
        return res;
    }
}