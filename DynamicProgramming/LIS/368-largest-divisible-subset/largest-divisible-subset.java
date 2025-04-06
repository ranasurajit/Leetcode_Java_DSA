class Solution {
    /**
     * Approach III : Using Tabulation Approach
     *
     * TC: O(N x log(N) + N + N ^ 2) ~ O(N ^ 2)
     * SC: O(N)
     *
     * Accepted (49 / 49 testcases passed), Beats ~ 70%
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        List<Integer> lds = new ArrayList<Integer>();

        // Sort the array and find the length of Longest Divisible Subset (LDS)
        Arrays.sort(nums); // TC: O(N x log(N))
        int lis = 1;
        int[] dp = new int[n]; // SC: O(N)
        Arrays.fill(dp, 1);
        
        for (int i = 1; i < n; i++) { // TC: O(N)
            for (int j = 0; j < i; j++) { // TC: O(N)
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    if (lis < dp[i]) {
                        lis = dp[i];
                    }
                }
            }
        }

        // Find one of the possible Longest Divisible Subset (LDS)
        int prev = -1;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            if (dp[i] == lis && (prev == -1 || prev % nums[i] == 0)) {
                lds.add(nums[i]);
                lis--;
                prev = nums[i];
            }
        }
        return lds;
    }

    /**
     * Approach II : Using Memoization Approach (Hashing Appproach)
     *
     * TC: O(N x log(N) + 2 ^ N) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Accepted (40 / 49 testcases passed), Beats < 10%
     */
    public List<Integer> largestDivisibleSubsetMemoization(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        Map<String, List<Integer>> memo = new HashMap<String, List<Integer>>();
        return solveMemoization(0, -1, n, nums, memo); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Memoization Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private List<Integer> solveMemoization(int index, int prevIndex, 
        int n, int[] nums, Map<String, List<Integer>> memo) {
        // Base Case
        if (index == n) {
            return new ArrayList<Integer>();
        }
        String key = index + "-" + prevIndex;
        // Memoization Check
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // Recursion Calls
        // nottake
        List<Integer> nottake = 
            solveMemoization(index + 1, prevIndex, n, nums, memo); // explore possibilities
        // take
        List<Integer> take = new ArrayList<Integer>();
        if (prevIndex == -1 || nums[index] % nums[prevIndex] == 0) { // divisible subset condition
            take.add(nums[index]);
            take.addAll(solveMemoization(index + 1, index, n, nums, memo));
        }
        List<Integer> result = take.size() > nottake.size() ? take : nottake;
        memo.put(key, result);
        return result;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N x log(N) + 2 ^ N) ~ O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (47 / 49 testcases passed)
     */
    public List<Integer> largestDivisibleSubsetRecursion(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        return solveRecursion(0, -1, n, nums); // TC: O(2 ^ N), SC: O(N)
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private List<Integer> solveRecursion(int index, int prevIndex, int n, int[] nums) {
        // Base Case
        if (index == n) {
            return new ArrayList<Integer>();
        }
        // Recursion Calls
        // nottake
        List<Integer> nottake = 
            solveRecursion(index + 1, prevIndex, n, nums); // explore possibilities
        // take
        List<Integer> take = new ArrayList<Integer>();
        if (prevIndex == -1 || nums[index] % nums[prevIndex] == 0) { // divisible subset condition
            take.add(nums[index]);
            take.addAll(solveRecursion(index + 1, index, n, nums));
        }
        return take.size() > nottake.size() ? take : nottake;
    }
}
