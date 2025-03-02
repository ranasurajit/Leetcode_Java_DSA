class Solution {
    /**
     * Approach II : Using Two-Pointers Approach
     * 
     * TC: O(M + N)
     * SC: O(M + N)
     */
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int p = 0; // pointer at beginning of array 'nums1'
        int q = 0; // pointer at beginning of array 'nums2'
        List<int[]> merged = new ArrayList<int[]>(); // SC: O(M + N)
        while (p < m && q < n) { // TC: O(M + N)
            if (nums1[p][0] == nums2[q][0]) {
                merged.add(new int[] { nums1[p][0], nums1[p][1] + nums2[q][1] });
                p++;
                q++;
            } else if (nums1[p][0] < nums2[q][0]) {
                merged.add(nums1[p]);
                p++;
            } else {
                merged.add(nums2[q]);
                q++;
            }
        }
        while (p < m) {
            merged.add(nums1[p]);
            p++;
        }
        while (q < n) {
            merged.add(nums2[q]);
            q++;
        }
        return merged.toArray(new int[merged.size()][2]);
    }

    /**
     * Approach I : Using TreeMap (To Keep Result sorted)
     * 
     * TC: O((M + N) x log(M + N))
     * SC: O(M + N)
     */
    public int[][] mergeArraysApproachI(int[][] nums1, int[][] nums2) {
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
