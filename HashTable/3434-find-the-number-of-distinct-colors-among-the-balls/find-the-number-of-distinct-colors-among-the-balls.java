class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(Q)
     * SC: O(2 x Q) ~ O(Q)
     */
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(Q)
        Map<Integer, Integer> colorMap = new HashMap<Integer, Integer>(); // SC: O(Q)
        int q = queries.length;
        int[] result = new int[q];
        int count = 0;
        for (int[] query : queries) { // TC: O(Q)
            if (colorMap.containsKey(query[0])) {
                int color = colorMap.get(query[0]);
                int freq = map.get(color);
                if (freq == 1) {
                    map.remove(color);
                } else {
                    map.put(color, freq - 1);
                }
            }
            map.put(query[1], map.getOrDefault(query[1], 0) + 1);
            colorMap.put(query[0], query[1]);
            result[count++] = map.size();
        }
        return result;
    }
}
