class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        Set<String> hs = new HashSet<String>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hs.add(arr[i]);
                hm.remove(arr[i]);
            } else {
                if (!hs.contains(arr[i])) {
                    hm.put(arr[i], i);
                }
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((p, q) -> p.index - q.index);
        for (String key : hm.keySet()) {
            pq.offer(new Pair(key, hm.get(key)));
        }
        String result = "";
        if (pq.size() < k) {
            return "";
        }
        int count = 1;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (count == k) {
                result = current.str;
            }
            count++;
        }
        return result;
    }

    class Pair {
        String str;
        int index;

        public Pair(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }
}
