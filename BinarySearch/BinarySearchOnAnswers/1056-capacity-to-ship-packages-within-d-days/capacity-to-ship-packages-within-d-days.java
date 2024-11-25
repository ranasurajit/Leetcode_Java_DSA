class Solution {
    /**
     * Using Optimal Approach
     *
     * TC: O(N + K x N)
     * SC: O(1)
     */
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysNeeded = daysNeededForCapacity(weights, n, mid);
            if (daysNeeded > days) { // TC: O(N)
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * Using Brute-Force Approach
     *
     * TC: O(N + K x N)
     * SC: O(1)
     */
    public int shipWithinDaysBruteForce(int[] weights, int days) {
        int n = weights.length;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        for (int i = low; i <= high; i++) { // TC: O(K), where K = (high - low)
            if (daysNeededForCapacity(weights, n, i) <= days) { // TC: O(N)
                return i;
            }
        }
        return -1;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private int daysNeededForCapacity(int[] weights, int n, int capacity) {
        int sum = 0;
        int days = 1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (sum + weights[i] > capacity) {
                days++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return days;
    }
}
