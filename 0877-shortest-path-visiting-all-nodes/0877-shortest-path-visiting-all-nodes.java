class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n==1) return 0;
        int target = (1<<n)-1;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] dp = new boolean[n][target+1];
        int cover = 0;
        int minDegree = Integer.MAX_VALUE;
        int ind = -1;
        for(int[] it:graph){
            minDegree = Math.min(minDegree,it.length);
        }
        for(int i=0;i<n;i++){
            if(graph[i].length==minDegree)
            q.add(new int[]{i,1<<i});
        }
        while(!q.isEmpty()){
            int size = q.size();
            cover++;
            while(size-->0){
                int[] t = q.poll();
                int in = t[0];
                int val = t[1];
                for(int nextIn:graph[in]){
                    int newval = val|(1<<nextIn);
                    if(newval==target)
                    return cover;
                    if(!dp[nextIn][newval]){
                        q.add(new int[]{nextIn,newval});
                        dp[nextIn][newval]=true;
                    }
                }
            }
        }
        return -1;
    }
}