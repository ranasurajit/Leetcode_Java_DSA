class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                int sum = st.peek() + asteroids[i];
                if (sum == 0) {
                    st.pop();
                    asteroids[i] = 0;
                } else if (sum < 0) {
                    st.pop();
                } else {
                    asteroids[i] = 0;
                }
            }
            if (asteroids[i] != 0) {
                st.push(asteroids[i]);
            }
        }
        int m = st.size();
        int[] result = new int[m];
        int index = m - 1;
        while (!st.isEmpty()) { // TC: O(N)
            result[index--] = st.pop();
        }
        return result;
    }
}
