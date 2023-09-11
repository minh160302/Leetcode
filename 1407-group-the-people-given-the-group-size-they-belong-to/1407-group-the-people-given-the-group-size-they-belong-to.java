class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> lst = map.getOrDefault(groupSizes[i], new ArrayList<>());
            lst.add(i);
            map.put(groupSizes[i], lst);
        }
        for (int size : map.keySet()) {
            int cnt = map.get(size).size() / size;
            for (int i = 0; i < cnt; i++) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    group.add(map.get(size).get(i * size + j));
                }
                res.add(group);
            }
        }
        return res;
    }
}