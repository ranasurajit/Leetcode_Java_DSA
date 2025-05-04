class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int i = 0; // pointer for unique elements
        int j = 0; // variable pointer to find unique elements
        while (j < nums.length) { // TC: O(N)
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int removeDuplicatesApproachI(int[] nums) {
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
