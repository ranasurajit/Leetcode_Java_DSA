class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int ormax = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            ormax = (ormax | nums[i]);
        }
        int[] count = { 0 };
        solve(0, nums, 0, ormax, count);
        return count[0];
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solve(int index, int[] nums, int current, int max, int[] count) {
        if (index == nums.length) {
            if (current == max) {
                count[0]++;
            }
            return;
        }
        // take
        solve(index + 1, nums, (current | nums[index]), max, count);
        // not take
        solve(index + 1, nums, current, max, count);
    }
}
