class Solution {
    /**
     * Approach II : Using Hashing Approach (Optimal)
     *
     * TC: O(N)
     * SC: O(100) ~ O(1)
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        // as per constraints, 1 <= dominoes[i][j] <= 9, if we form numbers it can't go beyond 100
        int[] map = new int[100];
        int count = 0;
        for (int[] pair : dominoes) { // TC: O(N)
            int num = pair[0] < pair[1] ? pair[0] * 10 + pair[1] : pair[1] * 10 + pair[0];
            count += map[num];
            map[num]++;
        }
        return count;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numEquivDominoPairsApproachI(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<String, Integer>(); // SC: O(N)
        for (int[] pair : dominoes) { // TC: O(N)
            int low = pair[0] < pair[1] ? pair[0] : pair[1];
            int high = pair[0] < pair[1] ? pair[1] : pair[0];
            String key = low + "-" + high;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (String key : map.keySet()) { // TC: O(N)
            int freq = map.get(key);
            if (freq > 1) {
                // number of pairs from count = nC2
                count += (freq * (freq - 1)) / 2;
            }
        }
        return count;
    }
}
