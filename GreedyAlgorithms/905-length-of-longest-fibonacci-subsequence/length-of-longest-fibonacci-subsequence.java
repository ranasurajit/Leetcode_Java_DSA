class Solution {
    /**
     * Using Greedy Approach (as hint given : strictly increasing array)
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashMap<Integer, Integer> indexMap =
            new HashMap<Integer, Integer>();  // SC: O(N)
        for (int i = 0; i < n; i++) {         // TC: O(N)
            indexMap.put(arr[i], i);
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
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
     * Using Memoization Approach (24 / 57 testcases passed)
     *
     * TC: O(2 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    public int lenLongestFibSubseqMemoization(int[] arr) {
        int n = arr.length;
        HashMap<String, Integer> memo = new HashMap<String, Integer>();
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        return solveMemoization(0, n, arr, current, 0, memo);
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveMemoization(int index, int n, int[] arr, 
        List<Integer> current, int maxSize, HashMap<String, Integer> memo) {
        if (index >= n) {
            if (current.size() >= 3) {
                maxSize = Math.max(maxSize, current.size());
            }
            return maxSize;
        }
        String key = index + "-" + String.valueOf(current);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // explore all possibilities
        int result = 0;
        if (current.size() < 2 || (index < n && 
            arr[index] == (current.get(current.size() - 1) + 
            current.get(current.size() - 2)))) {
            // include
            current.add(arr[index]);
            int x = solveMemoization(index + 1, n, arr, current, maxSize, memo);
            // exclude
            current.remove(current.size() - 1);
            int y = solveMemoization(index + 1, n, arr, current, maxSize, memo);
            result = Math.max(x, y);
        } else {
            // exclude
            result = solveMemoization(index + 1, n, arr, current, maxSize, memo);
        }
        memo.put(key, result);
        return result;
    }

    /**
     * Using Recursion Approach (24 / 57 testcases passed)
     *
     * TC: O(2 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    public int lenLongestFibSubseqRecursive(int[] arr) {
        int n = arr.length;
        List<Integer> current = new ArrayList<Integer>(); // SC: O(N)
        return solveRecursive(0, n, arr, current, 0);
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursive(int index, int n, int[] arr, 
        List<Integer> current, int maxSize) {
        if (index >= n) {
            if (current.size() >= 3) {
                maxSize = Math.max(maxSize, current.size());
            }
            return maxSize;
        }
        // explore all possibilities
        if (current.size() < 2 || (index < n && 
            arr[index] == (current.get(current.size() - 1) + 
            current.get(current.size() - 2)))) {
            // include
            current.add(arr[index]);
            int x = solveRecursive(index + 1, n, arr, current, maxSize);
            // exclude
            current.remove(current.size() - 1);
            int y = solveRecursive(index + 1, n, arr, current, maxSize);
            return Math.max(x, y);
        } else {
            // exclude
            return solveRecursive(index + 1, n, arr, current, maxSize);
        }
    }
}
