class Solution {
    /**
     * Using Two Pointers
     *
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int left = 0;
        int right = n - 1;
        int count = 0;
        int mod = 1000000007;
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (2 * power[i - 1]) % mod;
        }
        while (left <= right) { // TC: O(N)
            if (nums[left] + nums[right] <= target) {
                int diff = right - left;
                count = (count % mod + power[diff]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
