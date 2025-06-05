class Solution {
    /**
     * Approach : Using Queue Approach
     *
     * TC: O(N + K), where K = Sum(tickets)
     * SC: O(N)
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        Queue<int[]> queue = new LinkedList<int[]>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            queue.offer(new int[] { tickets[i], i });
        }
        int timeLapsed = 0;
        while (!queue.isEmpty()) { // TC: O(K)
            int[] current = queue.poll();
            if (current[0] - 1 > 0) {
                queue.offer(new int[] { current[0] - 1, current[1] });
            } else if (current[0] == 1 && current[1] == k) {
                // here the kth person will finish buying tickets
                break;
            }
            timeLapsed++;
        }
        // increased timeLapsed by 1 as we broke the loop without incrementing the time
        return timeLapsed + 1;
    }
}
