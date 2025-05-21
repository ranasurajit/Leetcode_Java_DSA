class Solution {
    /**
     * Approach II : Using Binary Search (On Answers) Approach
     *
     * TC: O(M x log(M x N))
     * SC: O(1)
     *
     * Accepted (70 / 70 testcases passed)
     */
    public int findKthNumber(int m, int n, int k) {
        // multiplication table will have low = 1 x 1, high = m x n
        int low = 1;
        int high = m * n;
        // Applying Binary Search
        while (low <= high) { // TC: O(log(M x N))
            int mid = low + (high - low) / 2;
            int countLessThanMid = getCountOfNumbersLessThanK(mid, m, n); // TC: O(M)
            if (countLessThanMid < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * Counting the number of elements in Multiplication Table less Mid value
     *
     * TC: O(M)
     * SC: O(1)
     */
    private int getCountOfNumbersLessThanK(int mid, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) { // TC: O(M)
            count += Math.min(mid / i, n);
        }
        return count;
    }

    /**
     * Approach I : Using Heap (PriorityQueue - Max Heap) Approach
     *
     * TC: O(M x N x log(K))
     * SC: O(K)
     *
     * Time Limit Exceeded (59 / 70 testcases passed)
     */
    public int findKthNumberApproachI(int m, int n, int k) {
        // For kth smallest number we can use a Max-Heap to store k elements
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(K)
        for (int i = 1; i <= m; i++) { // TC: O(M)
            for (int j = 1; j <= n; j++) { // TC: O(N)
                int current = (i * j);
                if (pq.size() < k) {
                    pq.offer(current); // TC: O(log(K))
                } else if (current < pq.peek()) {
                    pq.poll();
                    pq.offer(current); // TC: O(log(K))
                }
            }
        }
        return pq.peek();
    }
}
