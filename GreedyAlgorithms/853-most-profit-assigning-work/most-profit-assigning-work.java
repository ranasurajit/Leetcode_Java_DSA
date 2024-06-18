class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        PriorityQueue<Pair> pq = 
            new PriorityQueue<Pair>((Pair p, Pair q) -> q.profit - p.profit);
        for (int i = 0; i < profit.length; i++) {
            pq.offer(new Pair(difficulty[i], profit[i]));
        }
        Arrays.sort(worker);
        int n = worker.length;
        int count = n - 1;
        int maxProfit = 0;
        while (!pq.isEmpty() && count >= 0) {
            Pair currentPeek = pq.peek();
            if (currentPeek.difficulty > worker[count]) {
                pq.poll();
            } else {
                maxProfit += currentPeek.profit;
                count--;
            }
        }
        return maxProfit;
    }

    class Pair {
        int difficulty;
        int profit;

        public Pair (int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
