class Solution {
    /**
     * Approach IV : Using Optimized DP Approach
     *
     * TC: O(N x 32) ~ O(N)
     * SC: O(N x 32) ~ O(N)
     *
     * Time Limit Exceeded (75 / 85 testcases passed)
     */
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N ^ 2)
        Set<Integer> prev = new HashSet<Integer>();
        
        for (int i = 0; i < n; i++) { // TC: O(N)
            Set<Integer> current = new HashSet<Integer>();
            current.add(arr[i]);
            for (int val : prev) {
                current.add((val | arr[i]));
            }
            set.addAll(current);
            prev = current; // move to next index
        }
        return set.size();
    }

    /**
     * Approach III : Using Memoization (Top-Down DP) Approach
     *
     * TC: O(N x 32) ~ O(N)
     * SC: O(N x 32) + O(N) ~ O(N)
     *
     * Time Limit Exceeded (75 / 85 testcases passed)
     */
    public int subarrayBitwiseORsMemoization(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N ^ 2)
        Set<String> memo = new HashSet<String>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            solveMemoization(i, n, arr, 0, set, memo); // TC: O(32), SC: O(32)
        }
        return set.size();
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(32)
     * SC: O(32)
     */
    private void solveMemoization(int idx, int n, int[] arr, int currentOR,
        Set<Integer> set, Set<String> memo) {
        // Base Case
        if (idx == n) {
            return;
        }
        String key = idx + "|" + currentOR;
        // Memoization Check
        if (memo.contains(key)) {
            return;
        }
        // Recursion Calls
        currentOR = (currentOR | arr[idx]);
        set.add(currentOR);
        memo.add(key);
        solveRecursion(idx + 1, n, arr, currentOR, set);
    }

    /**
     * Approach II : Using Recursion Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2) + O(N)
     *
     * Time Limit Exceeded (75 / 85 testcases passed)
     */
    public int subarrayBitwiseORsRecursion(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N ^ 2)
        for (int i = 0; i < n; i++) { // TC: O(N)
            solveRecursion(i, n, arr, 0, set); // TC: O(N), SC: O(N)
        }
        return set.size();
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int n, int[] arr, int currentOR, Set<Integer> set) {
        // Base Case
        if (idx == n) {
            return;
        }
        // Recursion Calls
        currentOR = (currentOR | arr[idx]);
        set.add(currentOR);
        solveRecursion(idx + 1, n, arr, currentOR, set);
    }

    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     *
     * Time Limit Exceeded (76 / 85 testcases passed)
     */
    public int subarrayBitwiseORsBruteForce(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N ^ 2)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int prefixOR = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                set.add((prefixOR | arr[j]));
                prefixOR = (prefixOR | arr[j]);
            }
        }
        return set.size();
    }
}
