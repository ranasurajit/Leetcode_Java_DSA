class Solution {
    /**
     * Approach II : Using Stack Approach (Cleaner Approach)
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n]; // SC: O(N)
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 2 * n - 1; i >= 0; i--) { // TC: O(2 x N)
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            nums[i] = result[i];
        }
        return nums;
    }

    /**
     * Approach I : Using Stack Approach
     * 
     * TC: O(2 x M + N) ~ O(2 x M + 2 x M) ~ O(M)
     * SC: O(3 x N) ~ O(6 x M) ~ O(M)
     */
    public int[] nextGreaterElementsApproachI(int[] nums) {
        int m = nums.length;
        int n = 2 * m;
        int[] circularNums = new int[n]; // SC: O(N)
        for (int i = 0; i < m; i++) { // TC: O(M)
            circularNums[i] = nums[i];
            circularNums[m + i] = nums[i];
        }
        int[] result = new int[n]; // SC: O(N)
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (!st.isEmpty() && st.peek() <= circularNums[i]) {
                st.pop();
            }
            result[i] = st.isEmpty() ? -1 : st.peek();
            st.push(circularNums[i]);
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            nums[i] = result[i];
        }
        return nums;
    }
}
