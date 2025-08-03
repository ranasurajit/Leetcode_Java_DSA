class Solution {
    /**
     * Approach : Using Prefix-Array + Binary Search Approach
     *
     * TC: O(N) + O((K / 2) x 4 x log(N)) ~ O(N + K x log(N))
     * SC: O(N) + O(N) ~ O(N)
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] prefixSum = new int[n]; // SC: O(N)
        int[] pos = new int[n];       // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pos[i] = fruits[i][0]; // this is sorted already
            prefixSum[i] = fruits[i][1] + (i > 0 ? prefixSum[i - 1] : 0);
        }
        int maxFruits = 0;
        /**
         * let's consider that we walked d position either on left or right,
         * then remaining distance on other side = (k - d - d) i.e. = (k - 2d)
         * so (k - 2d) >= 0 i.e. d <= k / 2 so, d ranges between [0, k / 2] 
         */
        for (int d = 0; d <= k / 2; d++) { // TC: O(K / 2)
            // Case 1 - If we move left first and then right
            int remain = k - (2 * d);
            int left = startPos - d;
            int right = startPos + remain;
            /**
             * we will apply Binary Search on sorted array 'pos' to find 
             * the valid position from indices from which fruits can be 
             * harvested from
             */
            int leftIdx = lowerBound(pos, left); // TC: O(log(N))
            int rightIdx = upperBound(pos, right) - 1; // TC: O(log(N))
            if (leftIdx <= rightIdx) {
                int totalFruitsLR = prefixSum[rightIdx] - (leftIdx > 0 ? prefixSum[leftIdx - 1] : 0);
                maxFruits = Math.max(maxFruits, totalFruitsLR);
            }

            // Case 2 - If we move right first and then left
            left = startPos - remain;
            right = startPos + d;
            /**
             * we will apply Binary Search on sorted array 'pos' to find 
             * the valid position from indices from which fruits can be 
             * harvested from
             */
            leftIdx = lowerBound(pos, left); // TC: O(log(N))
            rightIdx = upperBound(pos, right) - 1; // TC: O(log(N))
            if (leftIdx <= rightIdx) {
                int totalFruitsLR = prefixSum[rightIdx] - (leftIdx > 0 ? prefixSum[leftIdx - 1] : 0);
                maxFruits = Math.max(maxFruits, totalFruitsLR);
            }
        }
        return maxFruits;
    }

    /**
     * Using Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int lowerBound(int[] pos, int target) {
        int low = 0;
        int high = pos.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Using Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] pos, int target) {
        int low = 0;
        int high = pos.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pos[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
