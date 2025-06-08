class Solution {
    /**
     * Approach II : Using DFS Approach
     *
     * TC: O(N)
     * SC: O(log(N))
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) { // TC: O(9)
            solve(i, n, result);       // TC: O(N), SC: O(log(N) Base 10)
        }
        return result;
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(9 x N) ~ O(N)
     * SC: O(log(N) Base 10) - Recursive Stack
     */
    private void solve(int current, int n, List<Integer> result) {
        // Base Case
        if (current > n) {
            return;
        }
        result.add(current);
        // Recursion Calls
        for (int i = 0; i <= 9; i++) { // TC: O(9)
            int newNum = current * 10 + i;
            if (newNum > n) {
                return;
            }
            solve(newNum, n, result); // TC: O(N)
        }
    }

    /**
     * Approach I : Using Heap(PriorityQueue) Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(N)
     */
    public List<Integer> lexicalOrderUsingHeaps(int n) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<String> pq = new PriorityQueue<String>(); // SC: O(N)
        for (int i = 1; i <= n; i++) {   // TC: O(N)
            pq.offer(String.valueOf(i)); // TC: O(log(N))
        }
        while (!pq.isEmpty()) { // TC: O(N)
            result.add(Integer.valueOf(pq.poll()));
        }
        return result;
    }
}
