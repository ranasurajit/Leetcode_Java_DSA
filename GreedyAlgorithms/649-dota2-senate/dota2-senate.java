class Solution {
    public String predictPartyVictory(String senate) {
        char[] senates = senate.toCharArray();
        Queue<Integer> rQueue = new LinkedList<Integer>();
        Queue<Integer> dQueue = new LinkedList<Integer>();
        for (int i = 0; i < senates.length; i++) {
            if (senates[i] == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int r = rQueue.poll();
            int d = dQueue.poll();
            if (r < d) {
                rQueue.offer((Integer) (d + senates.length));
            } else {
                dQueue.offer((Integer) (r + senates.length));
            }
        }
        return !rQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
