class Solution {
    /**
     * Approach III : Difference Array Approach with Binary Search
     *
     * TC: O(N + (Q + N) x log(Q)) ~ O((Q + N) x log(N))
     * SC: O(N)
     */
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        if (isZeroArray(nums, n)) { // TC: O(N)
            return 0;
        }
        int low = 0;
        int high = q - 1;
        int count = -1;
        while (low <= high) { // TC: O(log(Q))
            int mid = low + (high - low) / 2;
            if (checkWithDifferenceArray(nums, queries, n, mid)) { // TC: O(Q + N), SC: O(N)
                count = mid + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return count;
    }

    /**
     * Approach II : Difference Array Approach with Linear Search
     *
     * TC: O(N + Q x (Q + N)) ~ O(Q x (Q + N))
     * SC: O(N)
     */
    public int minZeroArrayApproachII(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int count = 0;
        if (isZeroArray(nums, n)) { // TC: O(N)
            return count;
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            if (checkWithDifferenceArray(nums, queries, n, i)) { // TC: O(Q + N), SC: O(N)
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * This will validate if zero array is formed using 'k' queries
     * 
     * TC: O(Q + N)
     * TC: O(N)
     */
    private boolean checkWithDifferenceArray(int[] nums, int[][] queries, int n, int k) {
        int[] diffArr = new int[n];
        // run k queries to check if Zero Array can be formed
        for (int i = 0; i <= k; i++) { // TC: O(Q)
            int start = queries[i][0];
            int end = queries[i][1];
            int increment = queries[i][2];
            diffArr[start] += increment;
            if (end + 1 < n) {
                diffArr[end + 1] -= increment;
            }
        }
        int cumulativeSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            cumulativeSum += diffArr[i];
            diffArr[i] = cumulativeSum;
            if (nums[i] > diffArr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(2 x Q x N) ~ O(Q x N)
     * SC: O(1)
     */
    public int minZeroArrayApproachI(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int count = 0;
        if (isZeroArray(nums, n)) { // TC: O(N)
            return count;
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int[] query = queries[i];
            for (int j = query[0]; j <= query[1]; j++) { // TC: O(N)
                nums[j] -= query[2];
                if (nums[j] < 0) {
                    nums[j] = 0;
                }
            }
            count++;
            if (isZeroArray(nums, n)) { // TC: O(N)
                return count;
            }
        }
        return -1;
    }

    /**
     * TC: O(N)
     * TC: O(1)
     */
    private boolean isZeroArray(int[] nums, int n) {
        boolean isValid = true;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] != 0) {
                return false;
            }
        }
        return isValid;
    }
}
