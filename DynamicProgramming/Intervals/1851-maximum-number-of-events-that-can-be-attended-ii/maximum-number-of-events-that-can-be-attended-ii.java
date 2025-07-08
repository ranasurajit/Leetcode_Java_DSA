class Solution {
    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O(2 ^ N) + O(N x log(N)) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (64 / 69 testcases passed)
     */
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (int[] a, int[] b) -> a[0] - b[0]); // TC: O(N x log(N))
        int[][] memo = new int[n + 1][k + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(0, n, k, events, memo); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int k, int[][] events, int[][] memo) {
        // Base Case
        if (idx == n || k == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[idx][k] != -1) {
            return memo[idx][k];
        }
        // Recursion Calls
        // we can choose to pick or skip
        int skip = solveMemoization(idx + 1, n, k, events, memo);
        int nextIdx = findNextNonOverlappingInterval(events, idx + 1, events[idx][1]); // TC: O(log(N))
        int pick = events[idx][2] + solveMemoization(nextIdx, n, k - 1, events, memo);
        return memo[idx][k] = Math.max(pick, skip);
    }

    /**
     * Using Binary Search to find next non-overlapping index
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int findNextNonOverlappingInterval(int[][] events, int start, int endTime) {
        int low = start;
        int high = events.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] > endTime) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N) + O(N x log(N)) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (64 / 69 testcases passed)
     */
    public int maxValueRecursion(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (int[] a, int[] b) -> a[1] - b[1]); // TC: O(N x log(N))
        return solveRecursion(0, -1, n, k, events); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int prevIndex, int n, int k, int[][] events) {
        // Base Case
        if (idx == n || k == 0) {
            return 0;
        }
        // Recursion Calls
        int pick = 0;
        int skip = 0;
        if (prevIndex == -1 || events[idx][0] > events[prevIndex][1]) {
            // we can choose to pick or skip
            pick = events[idx][2] + solveRecursion(idx + 1, idx, n, k - 1, events);
            skip = solveRecursion(idx + 1, prevIndex, n, k, events);
        } else {
            // we cannot choose to pick anyway
            skip = solveRecursion(idx + 1, prevIndex, n, k, events);
        }
        return Math.max(pick, skip);
    }
}
