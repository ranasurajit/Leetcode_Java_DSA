class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> q.frequency - p.frequency);
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer key : hm.keySet()) {
            pq.add(new Pair(key, hm.get(key)));
        }
        int[] top = new int[k];
        int index = 0;
        while (!pq.isEmpty() && index < k) {
            Pair current = pq.remove();
            top[index++] = current.digit;
        }
        return top;
    }

    class Pair {
        int digit;
        int frequency;

        public Pair(int digit, int frequency) {
            this.digit = digit;
            this.frequency = frequency;
        }
    }
}
