class Solution {
    /**
     * TC: O(Nlog(N) + O(Nlog(M)
     * SC: O(1)
     */
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);  // TC : O(Nlog(N))
        int low = 0; // lowest distance
        int high = nums[n - 1] - nums[0]; // highest distance
        int kthSmallest = 0;
        // Applying Binary search here TC: O(log(M))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int countPairs = getCountPairsBySlidingWindow(nums, mid); // TC: O(N)
            if (countPairs < k) {
                low = mid + 1;
            } else {
                kthSmallest = mid;
                high = mid - 1;
            }
        }
        return kthSmallest;
    }

    private int getCountPairsBySlidingWindow(int[] nums, int distance) {
        int i = 0;
        int j = i + 1;
        int count = 0;
        while (j < nums.length) {
            while (nums[j] - nums[i] > distance) {
                i++;
            }
            count += j - i;
            j++;
        }
        return count;
    }
}
