class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int cnt = map.getOrDefault(num, 0);
            cnt++;
            if (cnt > n/3 && !res.contains(num)) {
                res.add(num);
            }
            map.put(num, cnt);
        }
        return res;
    }
}