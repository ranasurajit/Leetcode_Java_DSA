class Solution {
    /**
     * Approach : Using Moore's Voting Algorithm Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int element = -1;
        int score = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (score == 0) {
                element = nums[i];
                score = 1;
            } else if (nums[i] == element) {
                score++;
            } else {
                score--;
            }
        }
        // chances are there that element is our majority element
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] == element) {
                count++;
            }
        }
        if (count > n / 2) {
            return element;
        }
        return -1;
    }
}
