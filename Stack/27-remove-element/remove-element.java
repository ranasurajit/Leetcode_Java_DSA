class Solution {
    public int removeElement(int[] nums, int val) {
        Stack<Integer> st = new Stack<Integer>();
        for (int it : nums) {
            if (it != val) {
                st.push(it);
            }
        }
        int count = 0;
        int size = st.size();
        while (!st.isEmpty()) {
            nums[count++] = st.pop();
        }
        return size;
    }
}
