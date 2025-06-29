class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Using Binary Search + Two Pointers + Array Pre-processing Approach
     *
     * TC: O(N x log(N)) + O(N) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int[] power = new int[n];
        power[0] = 1; // 2 ^ 0 value
        for (int i = 1; i < n; i++) { // TC: O(N)
            power[i] = (2 * power[i - 1]) % MOD;
        }
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int min = nums[i];
            int max = target - nums[i];
            if (max >= min) {
                int leftIndex = i;
                int rightIndex = upperBound(nums, n, max); // TC: O(log(N))
                int diff = rightIndex - leftIndex - 1;
                count = (count % MOD + power[diff] % MOD) % MOD;
            }
        }
        return count;
    }



    /**
     * Using Binary Search Approach
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] nums, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (15 / 63 testcases passed)
     */
    public int numSubseqRecursion(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        int[] count = { 0 };
        List<Integer> current = new ArrayList<Integer>();
        solveRecursion(0, n, nums, current, target, count);
        return count[0];
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int n, int[] nums, List<Integer> current,
        int target, int[] count) {
        // Base Case
        if (idx == n) {
            if (current.size() > 0 && current.get(0) + current.get(current.size() - 1) <= target) {
                count[0] = ((count[0] % MOD) + 1) % MOD;
            }
            return;
        }
        // Recursive Calls
        // take or not take
        // take
        current.add(nums[idx]);
        solveRecursion(idx + 1, n, nums, current, target, count);
        // not take
        current.remove(current.size() - 1);
        solveRecursion(idx + 1, n, nums, current, target, count);
    }
}
