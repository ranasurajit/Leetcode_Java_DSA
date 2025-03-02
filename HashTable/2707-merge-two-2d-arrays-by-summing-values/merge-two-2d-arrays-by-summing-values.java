class Solution {
    /**
     * Approach I : Using TreeMap (To Keep Result sorted)
     * 
     * TC: O((M + N) x log(M + N))
     * SC: O(M + N)
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>(); // SC: O(M + N)
        for (int[] item : nums1) { // TC: O(M)
            map.put(item[0], item[1]); // TC: O(log(M))
        }
        for (int[] item : nums2) { // TC: O(N)
            map.put(item[0], map.getOrDefault(item[0], 0) + item[1]); // TC: O(log(N))
        }
        int[][] merged = new int[map.size()][2];
        int index = 0;
        for (Integer key : map.keySet()) { // TC: O(M + N)
            merged[index][0] = key;
            merged[index++][1] = map.get(key);
        }
        return merged;
    }
}
