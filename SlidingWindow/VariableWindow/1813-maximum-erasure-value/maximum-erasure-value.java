class Solution {
    /**
     * Approach II : Using Sliding Window (Variable Size) (Cleaner) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N)
        int maxSum = 0;
        while (j < n) { // TC: O(N)
            sum += nums[j];
            while (i < n && set.contains(nums[j])) {
                // remove computation from index 'i'
                sum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            // set guarantees for unique elements
            maxSum = Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }

    /**
     * Approach I : Using Sliding Window (Variable Size) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public int maximumUniqueSubarrayHashMapApproach(int[] nums) {
        int n = nums.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        long sum = 0L;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        long maxSum = 0L;
        while (j < n) { // TC: O(N)
            sum += (long) nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() != 0 && j - i + 1 > map.size()) {
                // remove computation from index 'i'
                sum -= (long) nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            if (j - i + 1 == map.size()) {
                maxSum = Math.max(maxSum, sum);
            }
            j++;
        }
        return (int) maxSum;
    }
}
