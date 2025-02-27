class Solution {
    /**
     * Using Recursion
     *
     * TC: O(N ^ 3)
     * SC: O(N ^ 2)
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int maxLength = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int length = solve(j, k, arr, indexMap);
                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private int solve(int j, int k, int[] arr, Map<Integer, Integer> indexMap) {
        int target = arr[k] - arr[j]; // strictly increasing
        if (indexMap.containsKey(target) && indexMap.get(target) < j) {
            int i = indexMap.get(target);
            return 1 + solve(i, j, arr, indexMap);
        }
        return 2;
    }
}
