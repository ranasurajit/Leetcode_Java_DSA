class Solution {
    /**
     * Approach : Using Brute-Force (Two Pointers) Approach
     *
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        double[] result = new double[m + n]; // SC: O(M + N)
        int p = 0; // pointer at the start of array 'nums1'
        int q = 0; // pointer at the start of array 'nums2'
        int r = 0; // pointer at the start of array 'result'

        while (p < m && q < n) { // TC: O(M + N)
            if (nums1[p] < nums2[q]) {
                result[r] = (double) nums1[p];
                r++;
                p++;
            } else {
                result[r] = (double) nums2[q];
                r++;
                q++;
            }
        }
        while (p < m) {
            result[r] = (double) nums1[p];
            r++;
            p++;
        }
        while (q < n) {
            result[r] = (double) nums2[q];
            r++;
            q++;
        }
        int len = result.length;
        return (len & 1) == 0 ? (result[len / 2] + result[(len / 2) - 1]) / 2 : result[len / 2];
    }
}
