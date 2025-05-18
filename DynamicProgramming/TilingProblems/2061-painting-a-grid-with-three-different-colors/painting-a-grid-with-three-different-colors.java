class Solution {
    private static char[] colors = { 'R', 'G', 'B' };
    private static int MOD = (int) 1e9 + 7;

    /**
     * Approach II : Using Memoization Approach
     *
     * TC: O((S x M) x (N x S)), where S = number of states = 3 x 2 ^ (M - 1)
     * SC: O((S x M) + (N x S))
     *
     * Accepted (84 / 84 testcases passed)
     */
    public int colorTheGrid(int m, int n) {
        List<String> combinations = getColorCombinations(m); // TC: O(S), SC: O(S x M)
        int result = 0;
        int[][] memo = new int[n][combinations.size()]; // SC: O(N x S)
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        for (int i = 0; i < combinations.size(); i++) { // TC: O(S x M)
            result = (result + 
                solveWaysMemoization(n - 1, m, i, combinations, memo)) % MOD; // TC: O(N x S)
        }
        return result;
    }

    /**
     * Using Memoization
     *
     * TC: O(N x S)
     * SC: O(N)
     */
    private int solveWaysMemoization(int cols, int rows, int prevIndex,
        List<String> combinations, int[][] memo) {
        // Base Case
        if (cols == 0) {
            return 1;
        }
        // Memoization Check
        if (memo[cols][prevIndex] != -1) {
            return memo[cols][prevIndex];
        }
        int ways = 0;
        // Recursion Calls
        String prevState = combinations.get(prevIndex);
        for (int i = 0; i < combinations.size(); i++) {
            if (i == prevIndex) {
                continue;
            }
            boolean isValidColumn = true;
            String current = combinations.get(i);
            for (int j = 0; j < rows; j++) {
                if (prevState.charAt(j) == current.charAt(j)) {
                    isValidColumn = false;
                    break;
                }
            }
            if (isValidColumn) {
                ways = (ways + solveWaysMemoization(cols - 1, rows, i, combinations, memo)) % MOD;
            }
        }
        return memo[cols][prevIndex] = ways;
    }

    /**
     * Approach I : Using Recursion Approach
     *
     * TC: O(N x 2 ^ (M x N))
     * SC: O(N)
     *
     * Time Limit Exceeded (19 / 84 testcases passed)
     */
    public int colorTheGridRecursion(int m, int n) {
        List<String> combinations = getColorCombinations(m); // TC: O(2 ^ M), SC: O(M)
        int result = 0;
        for (int i = 0; i < combinations.size(); i++) { // TC: O(2 ^ M)
            result = (result + solveWaysRecursion(n - 1, m, i, combinations)) % MOD; // TC: O(N x 2 ^ N)
        }
        return result;
    }

    /**
     * Using Recursion
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private int solveWaysRecursion(int cols, int rows, int prevIndex, List<String> combinations) {
        // Base Case
        if (cols == 0) {
            return 1;
        }
        int ways = 0;
        // Recursion Calls
        String prevState = combinations.get(prevIndex);
        for (int i = 0; i < combinations.size(); i++) {
            if (i == prevIndex) {
                continue;
            }
            boolean isValidColumn = true;
            String current = combinations.get(i);
            for (int j = 0; j < rows; j++) {
                if (prevState.charAt(j) == current.charAt(j)) {
                    isValidColumn = false;
                    break;
                }
            }
            if (isValidColumn) {
                ways = (ways + solveWaysRecursion(cols - 1, rows, i, combinations)) % MOD;
            }
        }
        return ways;
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ M)
     * SC: SC: O(M x 2 ^ M)
     */
    private List<String> getColorCombinations(int m) {
        List<String> combinations = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(M)
        solveCombinations(0, m, ' ', sb, combinations); // TC: O(2 ^ M), SC: O(M x 2 ^ M)
        return combinations;
    }

    /**
     * Using Recursion
     *
     * TC: O(2 ^ M)
     * SC: O(M x 2 ^ M)
     */
    private void solveCombinations(int index, int m, char prev, StringBuilder sb,
        List<String> combinations) {
        // Base Case
        if (index == m) {
            if (sb.length() == m) {
                combinations.add(sb.toString());
            }
            return;
        }
        // Recursion Calls
        for (char ch : colors) {
            // not take
            solveCombinations(index + 1, m, prev, sb, combinations);
            if (prev == ' ' || prev != ch) {
                // take
                sb.append(ch);
                solveCombinations(index + 1, m, ch, sb, combinations);
                sb.setLength(sb.length() - 1); // backtrack
            }
        }
    }
}
