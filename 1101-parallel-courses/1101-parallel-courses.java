class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // init map
        HashMap<Integer, Integer> indegrees = new HashMap<>();
        HashMap<Integer, List<Integer>> topoMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            indegrees.put(i, 0);
            topoMap.put(i, new ArrayList<>());            
        }
        // build map
        for (int[] relation: relations) {
            int from = relation[0], to = relation[1];
            indegrees.put(from, indegrees.get(from) + 1);
            topoMap.get(to).add(from);
        }
        // topological sort
        int levels = 0;
        while (!indegrees.isEmpty()) {
            boolean hasCycle = true;
            List<Integer> deleted = new ArrayList<>();
            for (int key : indegrees.keySet()) {
                if (indegrees.get(key) == 0) {
                    deleted.add(key);
                    hasCycle = false;                    
                }
            }
            if (hasCycle)
                return -1;
            for (int k : deleted) {
                for (int parent : topoMap.get(k))
                    indegrees.put(parent, indegrees.get(parent) - 1);
                indegrees.remove(k);
            }
            levels++;
        }
        return levels;
    }
}