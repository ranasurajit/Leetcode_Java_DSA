class Solution {
    /*
     * Using Dynamic programming - Space Optimization Approach
     */
    public int tribonacci(int n) {
        int[] prev = {0, 1, 1};
        if (n < 3) {
            return prev[n];
        }
        for (int i = 3; i <= n; i++) {
            int current = prev[0] + prev[1] + prev[2];
            prev[0] = prev[1];
            prev[1] = prev[2];
            prev[2] = current;
        }
        return prev[2];
    }
}
