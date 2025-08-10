class Solution {
    /**
     * Approach II : Using Sorting + Bit-Manipulation Approach
     *
     * TC: O(N x log(N)) + O(32 x N x log(N)) ~ O(N x log(N))
     * SC: O(N) + O(32 x N) ~ O(N)
     *
     * Accepted (137 / 137 testcases passed)
     */
    public boolean reorderedPowerOf2(int n) {
        String sorted = getSortedValue(n); // TC: O(N x log(N)), SC: O(N)
        for (int i = 0; i < 32; i++) { // TC: O(32)
            if (sorted.equals(getSortedValue(1 << i))) { // TC: O(N x log(N)), SC: O(N)
                return true;
            }
        }
        return false;
    }

    /**
     * Using Sorting Approach
     *
     * TC: O(N x log(N))
     * SC: O(N)
     */
    private String getSortedValue(int n) {
        char[] digit = String.valueOf(n).toCharArray(); // SC: O(N)
        Arrays.sort(digit); // TC: O(N x log(N))
        return String.valueOf(digit);
    }

    /**
     * Approach I : Using Recursion + Backtracking + Bit-Manipulation Approach
     *
     * TC: O(N x log(N)) + O(M x N!) + O(N!)
     * SC: O(N) + O(N) + O(N) + O(N!) ~ O(N!)
     *
     * Memory Limit Exceeded (118 / 137 testcases passed)
     */
    public boolean reorderedPowerOf2UsingRecursionBacktracking(int n) {
        char[] digits = String.valueOf(n).toCharArray(); // SC: O(N)
        Arrays.sort(digits); // TC: O(N x log(N))
        int size = digits.length;
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        boolean[] isVisited = new boolean[n]; // SC: O(N)
        Set<Long> set = new HashSet<Long>();
        backtrack(digits, size, sb, isVisited, set); // TC: O(M x N!), SC: O(N!)
        for (Long num : set) { // TC: O(N!)
            if (isPowerOf2(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Using Recursion + Backtracking Approach
     *
     * TC: O(M x N!)
     * SC: O(N!)
     */
    private void backtrack(char[] digits, int size, StringBuilder sb,
        boolean[] isVisited, Set<Long> set) {
        // Base Case
        if (sb.length() == size) {
            set.add(Long.valueOf(sb.toString()));
            return;
        }
        // Recursion Calls
        for (int i = 0; i < size; i++) { // TC: O(M)
            // skip to add leading zeros
            if (sb.length() == 0 && digits[i] == '0') {
                continue;
            }
            // skip if digit at index 'i' is used already
            if (isVisited[i]) {
                continue;
            }
            // use the digit at index 'i'
            sb.append(digits[i]);
            isVisited[i] = true;
            backtrack(digits, size, sb, isVisited, set);
            // backtrack
            sb.setLength(sb.length() - 1);
            isVisited[i] = false;
        }
    }

    /**
     * Using Bit-Manipulation Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isPowerOf2(long num) {
        return (num & (num - 1)) == 0;
    }
}
