class Solution {
    /**
     * Using Stack to pre-compute the Next Greater Elements
     * 
     * TC: O(M + N)
     * SC: O(3 x N) ~ O(N)
    */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int[] result = new int[m];
        // SC: O(N)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        /**
          * we are going to pre-compute next greater element
          * for 'nums2' array
          */
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        int n = nums2.length;
        int[] nge = new int[n];            // SC: O(N)
        /** 
         * we need to store the array 'nums2' 
         * elements into HashMap to find the indices
         * in O(1)
         */
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            map.put(nums2[i], i);
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.add(nums2[i]);
        }
        for (int i = 0; i < m; i++) {      // TC: O(M)
            result[i] = nge[map.get(nums1[i])];
        }
        return result;
    }
}
