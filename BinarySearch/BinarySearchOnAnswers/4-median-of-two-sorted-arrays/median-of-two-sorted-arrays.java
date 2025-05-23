class Solution {
    /**
     * Approach II : Using Better (Two Pointers) Approach
     *
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m1 = nums1.length;
        int m2 = nums2.length;

        int n = m1 + m2;
        int second = n / 2;
        int first = second - 1;
        int median1 = 0;
        int median2 = 0;

        int p = 0; // pointer at the start of array 'nums1'
        int q = 0; // pointer at the start of array 'nums2'
        int r = 0; // count of the resultant array index

        while (p < m1 && q < m2) { // TC: O(M + N)
            if (nums1[p] < nums2[q]) {
                if (r == first) {
                    median1 = nums1[p];
                }
                if (r == second) {
                    median2 = nums1[p];
                }
                r++;
                p++;
            } else {
                if (r == first) {
                    median1 = nums2[q];
                }
                if (r == second) {
                    median2 = nums2[q];
                }
                r++;
                q++;
            }
        }
        while (p < m1) {
            if (r == first) {
                median1 = nums1[p];
            }
            if (r == second) {
                median2 = nums1[p];
            }
            r++;
            p++;
        }
        while (q < m2) {
            if (r == first) {
                median1 = nums2[q];
            }
            if (r == second) {
                median2 = nums2[q];
            }
            r++;
            q++;
        }
        return ((m1 + m2) & 1) == 0 ? (double) (median1 + median2) / 2.0 : (double) median2;
    }

    /**
     * Approach I : Using Brute-Force (Two Pointers) Approach
     *
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public double findMedianSortedArraysApproachI(int[] nums1, int[] nums2) {
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
