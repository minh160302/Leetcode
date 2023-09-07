class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());
        for (int[] time: times) {
            int u = time[0], v = time[1], w = time[2];
            map.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{k, 0});
        visited[k] = true;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0], cost = poll[1];
            if (dist[node] < cost)
                continue;
            for (int[] next : map.get(node)) {
                if (!visited[next[0]] || dist[next[0]] > dist[node] + next[1]) {                    
                    visited[next[0]] = true;
                    dist[next[0]] = dist[node] + next[1];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}