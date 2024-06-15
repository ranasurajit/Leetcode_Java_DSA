class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        // Priority Queue with sorting of capital in increasing order
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair a, Pair b) -> a.capital - b.capital);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(profits[i], capital[i]));
        }
        /*
         * Priority Queue with sorting of profits in decreasing order to track which 
         * project makes max profit for a given capital
         */
        PriorityQueue<Pair> pqmax = new PriorityQueue<Pair>((Pair a, Pair b) -> b.profit - a.profit);
        while ((!pq.isEmpty() || !pqmax.isEmpty()) && k > 0) {
            if (!pq.isEmpty() && pq.peek().capital <= w) {
                pqmax.offer(pq.poll());
            } else {
                if (!pqmax.isEmpty()) {
                    w += pqmax.poll().profit;
                    k--;
                } else {
                    break;
                }
            }
        }
        return w;
    }

    class Pair {
        int profit;
        int capital;

        public Pair (int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
}
