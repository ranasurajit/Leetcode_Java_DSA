class Solution {
    /**
     * Approach : Applying Greedy Approach and Sorting Approach
     *
     * TC: O(N x log(Q) + Q x log(Q))
     * SC: O(2 x Q) ~ O(Q)
     */
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        Arrays.sort(queries, (a, b) -> a[0] - b[0]); // TC: O(Q x log(Q))
        // Max-Heap to store the queries in order of end value of query
        PriorityQueue<Integer> availableQuery = new PriorityQueue<Integer>((a, b) -> b - a); // SC: O(Q)
        // Min-Heap to store the queries in order of end value of query
        PriorityQueue<Integer> usedQuery = new PriorityQueue<Integer>(); // SC: O(Q)
        int queryIdx = 0;
        int queryCount = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            // we are going to push end points of queries matching start point as index i
            while (queryIdx < q && queries[queryIdx][0] == i) {
                availableQuery.offer(queries[queryIdx][1]); // TC: O(log(Q))
                queryIdx++;
            }
            // adjust nums[i] with usedQuery
            nums[i] -= usedQuery.size();
            // apply the query if nums[i] > 0
            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end); // TC: O(log(Q))
                nums[i]--;
                queryCount++;
            }
            // if nums[i] could not be reduced to zero
            if (nums[i] > 0) {
                return -1;
            }
            // remove usedQuery with values = i
            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }
        return q - queryCount;
    }
}
