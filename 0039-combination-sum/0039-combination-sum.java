class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> current, int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (candidates[index] > target)
            return;
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(res, current, candidates, target - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}