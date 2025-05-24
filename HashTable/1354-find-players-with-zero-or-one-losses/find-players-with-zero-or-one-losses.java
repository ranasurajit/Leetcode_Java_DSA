class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(N + K x log(K))
     * SC: O(2 x K) ~ O(K)
     *
     * where K = number of players who played atleast 1 match
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, int[]> map = new TreeMap<Integer, int[]>(); // SC: O(K)
        for (int[] match : matches) { // TC: O(N)
            map.putIfAbsent(match[0], new int[] { 0, 0 });
            map.putIfAbsent(match[1], new int[] { 0, 0 });
            int[] winner = map.get(match[0]);
            winner[0] += 1;
            map.put(match[0], winner);
            int[] looser = map.get(match[1]);
            looser[1] += 1;
            map.put(match[1], looser);
        }
        List<Integer> winners = new ArrayList<Integer>(); // SC: O(P)
        List<Integer> loosers = new ArrayList<Integer>(); // SC: O(K - P)
        for (Integer key : map.keySet()) { // TC: O(K)
            int[] profile = map.get(key);
            if (profile[1] == 0) {
                winners.add(key); // TC: O(log(K)
            }
            if (profile[1] == 1) {
                loosers.add(key); // TC: O(log(K)
            }
        }
        result.add(winners);
        result.add(loosers);
        return result;
    }
}
