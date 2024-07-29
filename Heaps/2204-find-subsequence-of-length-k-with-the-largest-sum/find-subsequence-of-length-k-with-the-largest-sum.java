class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p, q) -> q.value - p.value);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i], i));
        }
        PriorityQueue<Pair> sorted = new PriorityQueue<Pair>((p, q) -> p.index - q.index);
        while (!pq.isEmpty() && k > 0) {
            Pair current = pq.poll();
            sorted.offer(current);
            k--;
        }
        int index = 0;
        while (!sorted.isEmpty()) {
            Pair current = sorted.poll();
            result[index++] = current.value;
        }
        return result;
    }

    class Pair {
        int value;
        int index;
        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
