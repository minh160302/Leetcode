class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                
                continue;
            }
            else {
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    if (k < n - 1 && nums[k] == nums[k + 1]) {
                        k--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    }
                    else if (nums[i] + nums[j] + nums[k] > 0) {
                        k--;
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);
                        j++;
                        k--;
                    }
                }
            }
        }
        return result;
    }
}