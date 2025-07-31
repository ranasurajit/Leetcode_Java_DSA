class Solution {
    /**
     * Approach IV : Using Optimized DP Approach
     *
     * TC: O(N x 32) ~ O(N)
     * SC: O(N x 32) ~ O(N)
     *
     * Accepted (85 / 85 testcases passed)
     */
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> result = new HashSet<Integer>(); // SC: O(N ^ 2)
        Set<Integer> prev = new HashSet<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            Set<Integer> current = new HashSet<Integer>();
            current.add(arr[i]);
            for (int val : prev) {
                current.add(val | arr[i]);
            }
            prev = current; // move to next index
            result.addAll(current);
        }
        return result.size();
    }
}
