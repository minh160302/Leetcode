class Solution {
    int res = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] cycles = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!cycles[i]) {
                int[] visited = new int[n];
                visited[i] = 1;
                findCycle(edges, i, cycles, visited);
            }
        }
        return res;
    }

    public void findCycle(int[] edges, int start, boolean[] cycles, int[] visited) {
        cycles[start] = true;
        int next = edges[start];
        if (next != -1 && !cycles[next]){
            visited[next] = visited[start] + 1;
            findCycle(edges, next, cycles, visited);
        }
        else if (next != -1 && visited[next] != 0) {
            res = Math.max(res, visited[start] - visited[next] + 1);
            return;
        }        
    }
}