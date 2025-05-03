class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(2 x (M + N)) ~ O(M + N)
     * SC: O(M + N)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> sorted = new ArrayList<Integer>();

        int p = 0; // pointer at start of array 'nums1'
        int q = 0; // pointer at start of array 'nums2'

        int[] merged = new int[m + n]; // SC: O(M + N)
        int k = 0;

        while (p < m && q < n) { // TC: O(M + N)
            if (nums1[p] < nums2[q]) {
                merged[k] = nums1[p];
                p++;
            } else {
                merged[k] = nums2[q];
                q++;
            }
            k++;
        }

        while (p < m) {
            merged[k] = nums1[p];
            p++;
            k++;
        }
        while (q < n) {
            merged[k] = nums2[q];
            q++;
            k++;
        }

        for (int i = 0; i < (m + n); i++) { // TC: O(M + N)
            nums1[i] = merged[i];
        }
    }
}
