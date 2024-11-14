class Solution {
    /**
     * Optimal Approach
     * 
     * TC: O(N + N x log(K)), where K = Maximum value in quantities array
     * SC: O(1)
     * 
     * @param quantities
     * @param n
     * @return
     */
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = getMax(quantities); // TC: O(N)
        int min = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(K))
            int mid = low + (high - low) / 2;
            if (isPossible(mid, n, quantities)) { // TC: O(N)
                min = Math.min(min, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return min;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param current
     * @param n
     * @param quantities
     * @return
     */
    private boolean isPossible(int current, int n, int[] quantities) {
        for (int q : quantities) {
            n = n - (int) (Math.ceil((double) q / (double) current));
            if (n < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param quantities
     * @return
     */
    private int getMax(int[] quantities) {
        int max = 0;
        for (int q : quantities) {
            max = Math.max(max, q);
        }
        return max;
    }
}
