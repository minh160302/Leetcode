class Solution {
    /*
        topological sort (Kahn)
        copy colors value from parent node to child node
     */
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
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0)
                queue.add(i);
        }
        int res = 0, nodeCount = 0;
        int[][] dp = new int[n][26];
        while (!queue.isEmpty()) {
            int p = queue.poll();
            nodeCount++;
            dp[p][colors.charAt(p) - 'a']++;    // max color count of all paths upto p
            res = Math.max(res, dp[p][colors.charAt(p) - 'a']);
            for (int next: map.get(p)) {
                for (int i = 0; i < 26; i++) {  // copy colors
                    dp[next][i] = Math.max(dp[next][i], dp[p][i]);
                }
                degrees[next]--;
                if (degrees[next] == 0)
                    queue.add(next);
            }
        }
        return nodeCount < n ? -1 : res;
    }
}