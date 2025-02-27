class Solution {
    /**
     * Approach IV: Using Greedy Algorithm
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {          // TC: O(N)
            indexMap.put(arr[i], i);
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {          // TC: O(N)
            for (int j = i + 1; j < n; j++) {  // TC: O(N)
                int first = arr[i];
                int second = arr[j];
                int currentLen = 2;
                while (indexMap.containsKey(first + second)) {
                    int third = first + second;
                    first = second;
                    second = third;
                    currentLen++;
                }
                maxLength = Math.max(maxLength, currentLen);
            }
        }
        return maxLength == 2 ? 0 : maxLength; 
    }

    /**
     * Approach III: Using Tabulation
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     */
    public int lenLongestFibSubseqApproachIII(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) {         // TC: O(N)
            indexMap.put(arr[i], i);
        }
        int[][] dp = new int[n][n];           // SC: O(N ^ 2)
        for (int[] dp1D : dp) {               // TC: O(N)
            Arrays.fill(dp1D, 2);
        }
        int maxLength = 0;
        for (int j = 1; j < n; j++) {         // TC: O(N)
            for (int k = j + 1; k < n; k++) { // TC: O(N)
                int target = arr[k] - arr[j];
                if (indexMap.containsKey(target) && indexMap.get(target) < j) {
                    int i = indexMap.get(target);
                    dp[j][k] = 1 + dp[i][j];
                }
                maxLength = Math.max(maxLength, dp[j][k]);
            }
        }
        return maxLength >= 3 ? maxLength : 0;
    }

    /**
     * Approach II: Using Memoization
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     */
    public int lenLongestFibSubseqApproachII(int[] arr) {
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
