class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] map = new int[201];
        for (int num: nums) {
            map[num]++;
            if (res.size() < map[num]) {
                res.add(new ArrayList<>());
            }
            res.get(map[num] - 1).add(num);
        }
        return res;
    }
}