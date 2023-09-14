class Solution {
    // topological sort
    /**
        2 hashmap: degrees and topo map
        
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> topoMap = new HashMap<>();
        // init
        for (int i = 0; i < numCourses; i++) {
            indegrees.put(i, 0);
            topoMap.put(i, new ArrayList<>());
        }
        // build
        for (int[] preq : prerequisites) {
            int next = preq[0], prev = preq[1];
            indegrees.put(next, indegrees.get(next) + 1);
            topoMap.get(prev).add(next);
        }
        // execute
        int[] order = new int[numCourses];
        int index = 0;
        while (!indegrees.isEmpty()) {
            boolean hasCycle = true;
            for (int key : indegrees.keySet()) {
                if (indegrees.get(key) == 0) {
                    hasCycle = false;
                    order[index++] = key;
                    for (int child : topoMap.get(key)) {
                        indegrees.put(child, indegrees.get(child) - 1);
                    }
                    indegrees.remove(key); 
                    break;                   
                }
            }
            if (hasCycle)
                return new int[]{};
        }
        return order;
    }
}