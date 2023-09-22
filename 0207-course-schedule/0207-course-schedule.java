class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // int[] degrees = new int[numCourses];
        HashMap<Integer, Integer> degrees = new HashMap<>();
        HashMap<Integer, List<Integer>> topoMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            degrees.put(i, 0);
            topoMap.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites) {
            int curr = pre[0], prev = pre[1];
            degrees.put(prev, degrees.get(prev) + 1);
            topoMap.get(curr).add(prev);
        }

        while (!degrees.isEmpty()) {
            boolean hasCycle = true;
            for (int key : degrees.keySet()) {
                if (degrees.get(key) == 0) {
                    hasCycle = false;
                    for (int parent : topoMap.get(key))
                        degrees.put(parent, degrees.get(parent) - 1);
                    degrees.remove(key);
                    break;
                }
            }
            if (hasCycle)
                return false;
        }
        return true;
    }
}