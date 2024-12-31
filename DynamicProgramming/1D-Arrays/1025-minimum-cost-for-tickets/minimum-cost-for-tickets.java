class Solution {
    /**
     * Using Tabulation Approach
     *
     * TC: O(Max(days))
     * SC: O(Max(days))
     */
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<Integer>();
        for (int day : days) {
            daySet.add(day);
        }
        int lastDay = days[days.length - 1] + 30;
        int[] dp = new int[lastDay + 1];
        for (int current = days[days.length - 1]; current >= 0; current--) {
            if (!daySet.contains(current)) {
                dp[current] = dp[current + 1];
                continue;
            }
            int daily = costs[0] + dp[current + 1];
            int weekly = costs[1] + dp[current + 7];
            int monthly = costs[2] + dp[current + 30];
            dp[current] = Math.min(daily, Math.min(weekly, monthly));
        }
        return dp[days[0]];
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(Max(days))
     * SC: O(Max(days) + N)
     */
    public int mincostTicketsMemoization(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<Integer>();
        for (int day : days) {
            daySet.add(day);
        }
        int[] dp = new int[days[days.length - 1] + 1];
        Arrays.fill(dp, -1);
        return solveMemoization(daySet, days, costs, days[0], dp);
    }

    private int solveMemoization(Set<Integer> daySet, int[] days, 
        int[] costs, int current, int[] dp) {
        if (current > days[days.length - 1]) {
            return 0;
        }
        if (dp[current] != -1) {
            return dp[current];
        }
        if (!daySet.contains(current)) {
            return 0 + solveMemoization(daySet, days, costs, current + 1, dp);
        }
        int daily = costs[0] + solveMemoization(daySet, days, costs, current + 1, dp);
        int weekly = costs[1] + solveMemoization(daySet, days, costs, current + 7, dp);
        int monthly = costs[2] + solveMemoization(daySet, days, costs, current + 30, dp);
        dp[current] = Math.min(daily, Math.min(weekly, monthly));
        return dp[current];
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(3 ^ 365)
     * SC: O(3 ^ 365)
     */
    public int mincostTicketsRecursion(int[] days, int[] costs) {
        Set<Integer> daySet = new HashSet<Integer>();
        for (int day : days) {
            daySet.add(day);
        }
        return solveRecursion(daySet, days, costs, days[0]);
    }

    private int solveRecursion(Set<Integer> daySet, int[] days, int[] costs, int current) {
        if (current > days[days.length - 1]) {
            return 0;
        }
        if (!daySet.contains(current)) {
            return 0 + solveRecursion(daySet, days, costs, current + 1);
        }
        int daily = costs[0] + solveRecursion(daySet, days, costs, current + 1);
        int weekly = costs[1] + solveRecursion(daySet, days, costs, current + 7);
        int monthly = costs[2] + solveRecursion(daySet, days, costs, current + 30);
        return Math.min(daily, Math.min(weekly, monthly));
    }
}
