class Solution {
    /**
     * Approach II : Using Monotonic Stack + Array Pre-Processing Approach
     *
     * TC: O(M x 2 x N) ~ O(M x N)
     * SC: O(3 x N) ~ O(N)
     */
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];   // SC: O(N)
        int count = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
            int[] sum = new int[n]; // SC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                while (!st.isEmpty() && heights[st.peek()] >= heights[j]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    sum[j] = heights[j] * (j + 1);
                } else {
                    int prev = st.peek();
                    sum[j] = sum[prev] + heights[j] * (j - prev);
                }
                st.push(j);
                count += sum[j];
            }
        }
        return count;
    }

    /**
     * Approach I : Using Simulation + Array Pre-Processing Approach
     *
     * TC: O(M x N x N)
     * SC: O(N)
     */
    public int numSubmatArrayPreProcess(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];   // SC: O(N)
        int count = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            // calculating histogram heights for each row comparing above column cell
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (mat[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) { // TC: O(N)
                int minHeight = heights[j];
                for (int k = j; k >= 0; k--) { // TC: O(N)
                    // getting minimum height matrix comparing till left
                    minHeight = Math.min(minHeight, heights[k]);
                    if (minHeight == 0) {
                        // no more valid matrix including this cell
                        break;
                    }
                    count += minHeight;
                }
            }
        }
        return count;
    }
}
