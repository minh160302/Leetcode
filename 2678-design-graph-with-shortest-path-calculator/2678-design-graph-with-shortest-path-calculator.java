class Graph {
    HashMap<Integer, List<int[]>> map;
    int n;

    public Graph(int n, int[][] edges) {
        this.map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        this.n = n;
        for (int[] edge: edges) {
            map.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }        
    }
    
    public void addEdge(int[] edge) {
        map.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{node1, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[0] == node2)
                return p[1];
            if (p[1] > costs[node2])
                continue;   // eliminates repeated calculations
            for (int[] edge: map.get(p[0])) {
                int nextCost = edge[1] + p[1];
                if (nextCost < costs[edge[0]]) {
                    costs[edge[0]] = nextCost;
                    pq.offer(new int[]{edge[0], nextCost});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */