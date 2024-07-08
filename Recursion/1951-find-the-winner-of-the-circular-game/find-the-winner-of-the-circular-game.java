class Solution {
    /**
     * Using Recursion
     */
    public int findTheWinner(int n, int k) {
        return 1 + helper(n, k);
    }

    private int helper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        int index = helper(n - 1, k);
        index = (index + k) % n;
        return index;
    }

    /**
     * Using Queues
     */
    // public int findTheWinner(int n, int k) {
    //     Queue<Integer> queue = new LinkedList<Integer>();
    //     for (int i = 1; i <= n; i++) {
    //         queue.offer(i);
    //     }
    //     while (queue.size() > 1) {
    //         int count = k - 1;
    //         while (count > 0) {
    //             queue.offer(queue.poll());
    //             count--;
    //         }
    //         queue.poll();
    //     }
    //     return queue.poll();
    // }
}