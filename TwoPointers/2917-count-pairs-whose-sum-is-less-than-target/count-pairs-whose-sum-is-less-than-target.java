class Solution {
    /**
     * Approach : Using Two Pointers and Sorting Approach
     * 
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        // Since we need pairs so order does not matter so we can sort array 'arr'
        Collections.sort(nums); // TC: O(N x log(N))
        int p = 0; // start pointer
        int q = n - 1; // end pointer
        int count = 0;
        while (p < q) { // TC: O(N)
            int sum = nums.get(p) + nums.get(q);
            if (sum < target) {
                count += (q - p);
                p++;
            } else {
                q--;
            }
        }
        return count;
    }
}
