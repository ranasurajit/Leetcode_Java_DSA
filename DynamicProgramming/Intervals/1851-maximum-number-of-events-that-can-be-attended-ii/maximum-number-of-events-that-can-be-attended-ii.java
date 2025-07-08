class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N x K) + O(N x K x log(N))
     * SC: O(N x K) + O(N)
     *
     * - O(N x K) - memoization array memory
     * - O(N) - recursion stack
     *
     * Accepted (69 / 69 testcases passed)
     */
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // TC: O(N x log(N))
        int[][] memo = new int[n + 1][k + 1]; // SC: O(N x K)
        for (int[] mem : memo) { // TC: O(N)
            Arrays.fill(mem, -1); // TC: O(K)
        }
        return solveMemoization(0, n, events, k, memo); // TC: O(N x K x log(N)), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(N x K x log(N))
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int[][] events, int k, int[][] memo) {
        // Base Case
        if (idx == n || k == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }
        // Recursion Calls
        // we have option to pick or skip an event at index 'idx'
        // skip
        int skip = solveMemoization(idx + 1, n, events, k, memo);
        int nextValidIndex = getNextValidEventIndex(idx + 1, n, events[idx][1], events); // TC: O(log(N))
        int pick = events[idx][2] + solveMemoization(nextValidIndex, n, events, k - 1, memo);
        return memo[idx][k] = Math.max(pick, skip);
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N x log(N)) + O(N x log(N)) ~ O(2 ^ N x log(N))
     * SC: O(N)
     *
     * - O(N) - recursion stack
     *
     * Time Limit Exceeded (64 / 69 testcases passed)
     */
    public int maxValueRecursion(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // TC: O(N x log(N))
        return solveRecursion(0, n, events, k); // TC: O(2 ^ N x log(N)), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N x log(N))
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, int[][] events, int k) {
        // Base Case
        if (idx == n || k == 0) {
            return 0;
        }
        // Recursion Calls
        // we have option to pick or skip an event at index 'idx'
        // skip
        int skip = solveRecursion(idx + 1, n, events, k);
        int nextValidIndex = getNextValidEventIndex(idx + 1, n, events[idx][1], events); // TC: O(log(N))
        int pick = events[idx][2] + solveRecursion(nextValidIndex, n, events, k - 1);
        return Math.max(pick, skip);
    }

    /**
     * Approach : Using Binary Search
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int getNextValidEventIndex(int start, int n, int endTime, int[][] events) {
        int low = start;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (events[mid][0] > endTime) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
