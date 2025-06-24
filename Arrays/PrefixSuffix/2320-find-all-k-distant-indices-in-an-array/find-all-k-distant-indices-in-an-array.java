class Solution {
    /**
     * Approach : Using Array Pre-Processing Approach
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        int[] prefixIndex = new int[n]; // SC: O(N)
        prefixIndex[0] = nums[0] == key ? 0 : Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixIndex[i] = nums[i] == key ? i : Math.min(prefixIndex[i - 1], Integer.MAX_VALUE);
        }
        int[] suffixIndex = new int[n]; // SC: O(N)
        suffixIndex[n - 1] = nums[n - 1] == key ? (n - 1) : Integer.MAX_VALUE;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffixIndex[i] = nums[i] == key ? i : Math.min(suffixIndex[i + 1], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (Math.abs(prefixIndex[i] - i) <= k || Math.abs(suffixIndex[i] - i) <= k) {
                result.add(i);
            }
        }
        return result;
    }
}
