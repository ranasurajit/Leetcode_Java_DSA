class Solution {
    /**
     * Recursion + Memoization Approach
     *
     * TC: O(N x log(N)), all events visited (all states x binary search)
     * SC: O(3 x N) ~ O(N)
     */
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (int[] a, int[] b) -> a[0] - b[0]);
        int count = 0;
        int[][] dp = new int[100001][3]; // states are index i and count
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solve(events, 0, n, count, dp);
    }

    private int solve(int[][] events, int index, int n, int count, int[][] dp) {
        // Base case
        if (index == n || count == 2) {
            return 0;
        }
        if (dp[index][count] != -1) {
            return dp[index][count];
        }
        // take
        int validNextIndex = 
            upperBound(events, events[index][1], index + 1, n); // TC: O(log(K))
        int take = events[index][2] + solve(events, validNextIndex, n, count + 1, dp);
        // not take
        int nottake = solve(events, index + 1, n, count, dp);
        return dp[index][count] = Math.max(take, nottake);
    }

    /**
     * Binary Search to get upper bound
     *
     * TC: O(log(K))
     * SC: O(1)
     */
    private int upperBound(int[][] events, int endTime, int low, int n) {
        int high = n - 1;
        int result = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int maxTwoEventsBruteForce(int[][] events) {
        int n = events.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int val = events[i][2];
            maxSum = Math.max(maxSum, events[i][2]);
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i == j) {
                    continue;
                }
                if (isOverlapping(events[i], events[j])) {
                    continue;
                }
                maxSum = Math.max(maxSum, val + events[j][2]);
            }
        }
        return maxSum;
    }

    private boolean isOverlapping(int[] a, int[] b) {
        return b[0] <= a[1] && b[1] >= a[0]; 
    }
}
