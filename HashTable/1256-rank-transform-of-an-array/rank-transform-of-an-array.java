class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ranks = new int[n];
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            tm.put(arr[i], tm.getOrDefault(arr[i], 0) + 1);
        }
        int index = 0;
        int rank = 1;
        for (Integer key : tm.keySet()) { // TC: O(N)
            tm.put(key, rank++);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            ranks[i] = tm.get(arr[i]);
        }
        return ranks;
    }
}
