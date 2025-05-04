class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<Integer>(); // SC: O(N)
        for (int item : nums) { // TC: O(N)
            set.add(item); // TC: O(log(N))
        }
        int index = 0;
        for (Integer key : set) { // TC: O(N)
            nums[index++] = key;
        }
        return index;
    }
}
