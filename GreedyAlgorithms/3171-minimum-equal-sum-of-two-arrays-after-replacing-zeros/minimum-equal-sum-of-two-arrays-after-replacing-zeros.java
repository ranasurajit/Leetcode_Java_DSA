class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(M + N)
     * SC: O(1)
     */
    public long minSum(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        long zeroescount1 = 0L;
        long zeroescount2 = 0L;
        long sum1 = 0L;
        long sum2 = 0L;
        for (int i = 0; i < m; i++) { // TC: O(M)
            sum1 += (long) nums1[i];
            if (nums1[i] == 0) {
                zeroescount1++;
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum2 += (long) nums2[i];
            if (nums2[i] == 0) {
                zeroescount2++;
            }
        }
        long requiredSum = 0L;
        requiredSum = Math.max(sum1 + zeroescount1, sum2 + zeroescount2);
        if (zeroescount1 == 0 && requiredSum - sum1 != 0) {
            return -1;
        }
        if (zeroescount2 == 0 && requiredSum - sum2 != 0) {
            return -1;
        }
        return requiredSum;
    }
}
