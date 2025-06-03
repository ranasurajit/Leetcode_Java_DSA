class Solution {
    /**
     * Approach : Using Stack Approach
     * 
     * TC: O(M + N)
     * SC: O(3 x M) ~ O(M)
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[m]; // SC: O(M)
        Stack<Integer> st = new Stack<Integer>(); // SC: O(M)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(M)
        for (int i = m - 1; i >= 0; i--) { // TC: O(M)
            while (!st.isEmpty() && st.peek() <= nums2[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
            map.put(nums2[i], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) { // TC: O(N)
            result[i] = nge[map.get(nums1[i])];
        }
        return result;
    }
}
