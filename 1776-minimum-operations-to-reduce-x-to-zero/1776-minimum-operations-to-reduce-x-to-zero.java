class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer, Integer> sumForward = new HashMap<>(), sumBackward = new HashMap<>();
        int fw = 0, bw = 0;
        for (int i = 0; i < n; i++) {
            fw += nums[i];
            if (fw <= x) {
                sumForward.put(fw, i + 1);
            }
            else
                break;
        }
        for (int i = n-1; i >= 0; i--) {
            bw += nums[i];
            if (bw <= x) {
                sumBackward.put(bw, n - i);
            }
            else
                break;
        }
        int res = Integer.MAX_VALUE;
        if (sumForward.containsKey(x))
            res = sumForward.get(x);
        if (sumBackward.containsKey(x))
            res = Math.min(res, sumBackward.get(x));
        for (int key : sumForward.keySet()) {
            int cnt1 = sumForward.get(key);
            if (key == x)
                res = Math.min(res, cnt1);
            else if (sumBackward.containsKey(x - key)) {
                int totalCnt = cnt1 + sumBackward.get(x - key);
                if (totalCnt <= n)
                    res = Math.min(res, totalCnt);   
            }                
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}