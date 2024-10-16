class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder happy = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> q.freq - p.freq);
        if (a > 0) {
            pq.offer(new Pair(a, 'a'));
        }
        if (b > 0) {
            pq.offer(new Pair(b, 'b'));
        }
        if (c > 0) {
            pq.offer(new Pair(c, 'c'));
        }
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int freq = current.freq;
            char ch = current.ch;
            int size = happy.length();
            if (size >= 2 && ch == happy.charAt(size - 1) && ch == happy.charAt(size - 2)) {
                if (pq.isEmpty()) {
                    break;
                }
                Pair next = pq.poll();
                int nextFreq = next.freq;
                char nextCh = next.ch;
                happy.append(nextCh);
                nextFreq--;
                if (nextFreq > 0) {
                    pq.offer(new Pair(nextFreq, nextCh));
                }
                pq.offer(current);
            } else {
                happy.append(ch);
                freq--;
                if (freq > 0) {
                    pq.offer(new Pair(freq, ch));
                }
            }
        }
        return happy.toString();
    }

    class Pair {
        int freq;
        char ch;
        public Pair (int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }
}
