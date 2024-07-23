class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((Pair p, Pair q) -> {
                if (p.freq == q.freq) {
                    return p.value > q.value ? 
                        (q.value - p.value) : (q.value - p.value);
                } else {
                    return p.freq - q.freq;
                }
            });
        for (Integer key : hm.keySet()) {
            pq.offer(new Pair(key, hm.get(key)));
        }
        System.out.println(hm);
        int index = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            while (current.freq > 0) {
                freq[index++] = current.value;
                current.freq--;
            }
        }
        return freq;
    }

    class Pair {
        int value;
        int freq;
        public Pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
}
