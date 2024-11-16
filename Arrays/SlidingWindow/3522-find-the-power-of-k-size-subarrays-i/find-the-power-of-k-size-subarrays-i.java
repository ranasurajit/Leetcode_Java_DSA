class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] power = new int[n - k + 1];
        Arrays.fill(power, -1);
        int count = 1;
        for (int i = 1; i < k; i++) { // TC: O(K)
            if (nums[i] == 1 + nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count == k) {
            power[0] = nums[k - 1];
        }
        int i = 1;
        int j = k;
        while (j < n) { // TC: O(N - K)
            if (nums[j] == 1 + nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count >= k) {
                power[i] = nums[j];
            }
            i++;
            j++;
        }
        return power;
    }
}
