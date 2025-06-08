class Solution {
    /**
     * Approach : Using Heap(PriorityQueue) Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(N)
     */
    public List<Integer> lexicalOrder(int n) {
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
