class Solution {
    /**
     * Approach II: Using Memoization
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int[][] memo = new int[n][n];
        for (int[] memoItems : memo) {
            Arrays.fill(memoItems, -1);
        }
        int maxLength = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int length = solveMemoization(j, k, arr, indexMap, memo);
                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private int solveMemoization(int j, int k, int[] arr,
        Map<Integer, Integer> indexMap, int[][] memo) {
        if (memo[j][k] != -1) {
            return memo[j][k];
        } 
        int target = arr[k] - arr[j]; // strictly increasing
        if (indexMap.containsKey(target) && indexMap.get(target) < j) {
            int i = indexMap.get(target);
            return memo[j][k] = 1 + solveMemoization(i, j, arr, indexMap, memo);
        }
        return memo[j][k] = 2;
    }

    /**
     * Approach I: Using Recursion
     *
     * TC: O(N ^ 3)
     * SC: O(N ^ 2)
     */
    public int lenLongestFibSubseqApproachI(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int maxLength = 0;
        for (int j = 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int length = solveRecursion(j, k, arr, indexMap);
                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private int solveRecursion(int j, int k, int[] arr,
        Map<Integer, Integer> indexMap) {
        int target = arr[k] - arr[j]; // strictly increasing
        if (indexMap.containsKey(target) && indexMap.get(target) < j) {
            int i = indexMap.get(target);
            return 1 + solveRecursion(i, j, arr, indexMap);
        }
        return 2;
    }
}
