class Solution {
    /**
     * Approach III : Using Smart Recursion Approach
     *
     * TC: O((log(N) base 10) x (log(N) base 10))
     * SC: O(log(N) base 10)
     *
     * Accepted (69 / 69 testcases passed)
     */
    public int findKthNumber(int n, int k) {
        long current = 1L;
        k--;
        while (k > 0) { // TC: O((log(N) base 10)
            // 10 nodes reduced each step
            long count = countSteps(current, current + 1, n); // TC: O((log(N) base 10)
            if (count <= k) {
                // skipping the current tree node
                current += 1;
                k -= count;
            } else {
                current = current * 10;
                k--;
            }
        }
        return (int) current;
    }

    /**
     * Using Similation Approach
     *
     * TC: O((log(N) base 10)
     * SC: O(1)
     */
    private long countSteps(long current, long next, int n) {
        long count = 0;
        while (current <= n) {
            count += (next - current);
            current = current * 10;
            next = Math.min(next * 10, n + 1);
        }
        return count;
    }

    /**
     * Approach II : Using Recursion Approach
     *
     * TC: O(K)
     * SC: O(K)
     *
     * Memory Limit Exceeded (39 / 69 testcases passed)
     */
    public int findKthNumberRecursion(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) { // TC: O(9)
            solveRecursion(i, n, k, list); // TC: O(K)
        }
        return list.get(k - 1);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(K)
     * SC: O(K)
     */
    private void solveRecursion(int num, int n, int k, ArrayList<Integer> list) {
        // Base Case
        if (num > n) {
            return;
        }
        if (list.size() == k) {
            return;
        }
        // Recursion Calls
        list.add(num);
        for (int i = 0; i <= 9; i++) {
            int currentNum = 10 * num + i;
            if (currentNum > n) {
                return;
            }
            solveRecursion(currentNum, n, k, list);
        }
    }

    /**
     * Approach I : Using Max-Heap (PriorityQueue) Approach
     *
     * TC: O(N x log(K))
     * SC: O(K)
     *
     * Time Limit Exceeded (31 / 69 testcases passed)
     */
    public int findKthNumberUsingHeaps(int n, int k) {
        PriorityQueue<String> pq = new PriorityQueue<String>((p, q) -> q.compareTo(p)); // SC: O(K)
        for (int i = 1; i <= n; i++) { // TC: O(N)
            if (pq.size() < k) {
                pq.offer(String.valueOf(i)); // TC: O(log(K))
            } else {
                if (String.valueOf(i).compareTo(pq.peek()) < 0) {
                    pq.poll();
                    pq.offer(String.valueOf(i)); // TC: O(log(K))
                }
            }
        }
        return Integer.valueOf(pq.peek());
    }
}
