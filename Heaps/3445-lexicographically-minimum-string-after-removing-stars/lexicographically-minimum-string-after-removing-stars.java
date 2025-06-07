class Solution {
    /**
     * Approach : Using Heaps (PriorityQueue) Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    public String clearStars(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        // we will be storing { char[i] - 'a', index } in the Heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p, q) -> {
            if (p[0] == q[0]) {
                return q[1] - p[1];
            }
            return p[0] - q[0];
        }); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (chars[i] != '*') {
                pq.offer(new int[] { chars[i] - 'a', i }); // TC: O(log(N))
            } else {
                int idx = pq.poll()[1];
                chars[idx] = '$';
                chars[i] = '$';
            }
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (chars[i] != '$') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
