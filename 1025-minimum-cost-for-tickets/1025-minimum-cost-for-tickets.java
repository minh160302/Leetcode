class Solution {
    /**
        dp[i] = min(dp[i], dp[i - 1] + cost[0])
        dp[i] = min(dp[i], dp[i - 7] + cost[1])
        dp[i] = min(dp[i], dp[i - 30] + cost[2])
     */
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] existingDays = new boolean[366];
        for (int day: days) 
            existingDays[day] = true;
        
        int finalDay = days[days.length - 1];
        int[] dp = new int[finalDay+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= finalDay; i++) {
            if (!existingDays[i])
                dp[i] = dp[i - 1];
            else {
                dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            }
        }
        return dp[finalDay];
    }
}