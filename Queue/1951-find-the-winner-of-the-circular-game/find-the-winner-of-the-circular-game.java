class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            int count = k - 1;
            while (count > 0) {
                queue.offer(queue.poll());
                count--;
            }
            queue.poll();
        }
        return queue.poll();
    }
}
