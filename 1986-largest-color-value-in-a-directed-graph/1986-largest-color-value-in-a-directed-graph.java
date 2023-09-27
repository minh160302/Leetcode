class Solution {  
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        int[] degrees = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());
        for (int[] edge: edges) {
            int from = edge[0], to = edge[1];
            map.get(from).add(to);
            degrees[to]++;
        }
        // let dp[u][c] := the maximum count of vertices with color c of any path starting from vertex u.
        int[][] dp = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) { // leaf
            if (degrees[i] == 0)
                queue.add(i);
        }
        int res = 0, nodeSeen = 0;
        while (!queue.isEmpty()) {  // Kahn's algorithm implemented in bfs style
            int p = queue.poll();
            dp[p][colors.charAt(p) - 'a']++;
            res = Math.max(res, dp[p][colors.charAt(p) - 'a']);
            nodeSeen++;            
            for (int next: map.get(p)) {
                for (int i = 0; i < 26; i++) {
                    dp[next][i] = Math.max(dp[next][i], dp[p][i]);  
                    // copy results from all colors filled by parents to children nodes
                }
                degrees[next]--;
                if (degrees[next] == 0)
                    queue.add(next);
            }
        }
        return nodeSeen < n ? -1 : res;
    }
}