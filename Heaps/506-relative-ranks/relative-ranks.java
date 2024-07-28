class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> q.score - p.score);
        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(score[i], i));
        }
        int rankIndex = 1;
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            result[current.index] = getRank(rankIndex++);
        }
        return result;
    }

    private String getRank(int rankIndex) {
        if (rankIndex == 1) {
            return "Gold Medal";
        } else if (rankIndex == 2) {
            return "Silver Medal";
        } else if (rankIndex == 3) {
            return "Bronze Medal";
        } else {
            return String.valueOf(rankIndex);
        }
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
