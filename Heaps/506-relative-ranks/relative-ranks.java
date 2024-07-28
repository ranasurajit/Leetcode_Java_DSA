class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        String[] medals = { "Gold Medal", "Silver Medal", "Bronze Medal" };
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> q.score - p.score);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(score[i], i));
        }
        int rankIndex = 0;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            if (rankIndex < medals.length) {
                result[current.index] = medals[rankIndex];
            } else {
                result[current.index] = String.valueOf(rankIndex + 1);
            }
            rankIndex++;
        }
        return result;
    }

    class Pair {
        int score;
        int index;
        public Pair(int score, int index) {
            this.score = score;
            this.index = index;
        }
    }
}
