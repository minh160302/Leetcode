class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int cnt = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        while (cnt > 0) {
            List<Integer> row = new ArrayList<>();
            for (int key : map.keySet()) {
                if (map.get(key) > 0) {
                    row.add(key);
                    map.put(key, map.get(key) - 1);
                    cnt--;
                }
            }
            res.add(row);
        }
        return res;
    }
}