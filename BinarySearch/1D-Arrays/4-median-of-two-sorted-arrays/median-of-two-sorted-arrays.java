class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // always make the 1st parameter to be the smallest array
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // nums1 is the array with less elements
        int low = 0;
        int high = m;
        while (low <= high) {
            // mid element of 1st array
            int px = low + (high - low) / 2;
            // segment of 2nd array
            int py = ((m + n + 1) / 2) - px;
            int x1 = px == 0 ? Integer.MIN_VALUE : nums1[px - 1];
            int x2 = py == 0 ? Integer.MIN_VALUE : nums2[py - 1];
            int x3 = px == m ? Integer.MAX_VALUE : nums1[px];
            int x4 = py == n ? Integer.MAX_VALUE : nums2[py];
            
            if (x1 <= x4 && x2 <= x3) {
                // we are on the correct pivot
                if ((m + n) % 2 == 0) {
                    // merged array would be even
                    return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
                } else {
                    // merged array would be odd
                    return Math.max(x1, x2);
                }
            } else if (x1 > x4) {
                high = px - 1;
            } else {
                low = px + 1;
            }
        }
        return -1.0;
    }
}
