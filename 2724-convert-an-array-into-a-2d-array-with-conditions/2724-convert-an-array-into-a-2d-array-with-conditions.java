class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for (int num: nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            map.put(num, cnt);
            size = Math.max(size, cnt);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < size; i++)
            res.add(new ArrayList<>());
        for (int key: map.keySet()) {
            for (int i = 0; i < map.get(key); i++)
                res.get(i).add(key);
        }
        return res;
    }
}