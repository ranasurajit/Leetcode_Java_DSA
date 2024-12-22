class Solution {
    private int[] segTree; // Segment Tree

    /**
     * TC: O(N + Q x log(N) x log(N))
     * SC: O(Q + N + log(N))
     */
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        segTree = new int[4 * n + 1];
        int sIndex = 1; // starting index of segment tree
        buildSegmentTree(heights, 0, n - 1, sIndex); // TC: O(N), SC: O(N)

        ArrayList<Integer> result = new ArrayList<Integer>(); // SC: O(Q)
        for (int[] query : queries) { // TC: O(Q)
            int alice = Math.min(query[0], query[1]);
            int bob = Math.max(query[0], query[1]);
            if (alice == bob || heights[alice] < heights[bob]) {
                // if queries have same value then alice and bob are at same index
                // heights[alice] < heights[bob] then alice will move to meet bob
                result.add(bob);
                continue;
            }
            // Binary Search + Range Max Query (RMQ - Next greater element)
            int low = bob;
            int high = n - 1;
            int ans = Integer.MAX_VALUE;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                // TC: O(log(N))
                int rmq = rangeMaxQuery(heights, low, mid, 0, n - 1, sIndex); 
                if (heights[rmq] > heights[alice]) {
                    high = mid - 1;
                    ans = Math.min(ans, rmq);
                } else {
                    low = mid + 1;
                }
            }
            result.add(ans == Integer.MAX_VALUE ? -1 : ans);
        }
        int[] queryRes = new int[q];
        for (int i = 0; i < q; i++) {
            queryRes[i] = result.get(i);
        }
        return queryRes;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)    
     */
    private int rangeMaxQuery(int[] heights, int qs, int qe, 
        int start, int end, int stIdx) {
        if (start >= qs && end <= qe) // Total Overlap
            return segTree[stIdx];
        if (start > qe || end < qs)   // No Overlap
            return Integer.MIN_VALUE;

        // Partial Overlap
        int mid = start + (end - start) / 2;
        int leftMax = rangeMaxQuery(heights, qs, qe, start, mid, 2 * stIdx);
        int rightMax = rangeMaxQuery(heights, qs, qe, mid + 1, end, 2 * stIdx + 1);

        if (leftMax == Integer.MIN_VALUE) return rightMax;
        if (rightMax == Integer.MIN_VALUE) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }

    /**
     * TC: O(N)
     * SC: O(N)    
     */
    private void buildSegmentTree(int[] heights, int start, int end, int sIndex) {
        if (start == end) {
            segTree[sIndex] = start;
            return;
        }
        int mid = start + (end - start) / 2;
        buildSegmentTree(heights, start, mid, sIndex * 2);
        buildSegmentTree(heights, mid + 1, end, sIndex * 2 + 1);
        segTree[sIndex] = heights[segTree[2 * sIndex]] >= 
            heights[segTree[2 * sIndex + 1]] ? 
            segTree[2 * sIndex] : segTree[2 * sIndex + 1];
    }
}
