class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> {
            if (p.soldiers == q.soldiers) {
                return p.index - q.index;
            } else {
                return p.soldiers - q.soldiers;
            }
        });
        for (int i = 0; i < rows; i++) {
            int soldiers = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    soldiers++;
                }
            }
            pq.offer(new Pair(i, soldiers));
        }
        int[] weakest = new int[k];
        int index = 0;
        while (!pq.isEmpty() && k > 0) {
            weakest[index++] = pq.poll().index;
            k--;
        }
        return weakest;
    }

    class Pair {
        int index;
        int soldiers;
        public Pair(int index, int soldiers) {
            this.index = index;
            this.soldiers = soldiers;
        }
    }
}
