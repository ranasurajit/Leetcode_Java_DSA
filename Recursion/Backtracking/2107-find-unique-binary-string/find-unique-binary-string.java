class Solution {
    /**
     * Approach II : Using Hashing Approach
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hs.add(Integer.parseInt(nums[i], 2));
        }
        String result = "";
        // we would loop from 0 to n
        for (int i = 0; i <= n; i++) { // TC: O(N)
            if (!hs.contains(i)) {
                result = Integer.toBinaryString(i); // TC: O(N)
                while (result.length() < n) {
                    result = "0" + result;
                }
                return result;
            }
        }
        return "";
    }

    /**
     * Approach I : Using Backtracking Approach
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public String findDifferentBinaryStringUsingBacktracking(String[] nums) {
        int n = nums.length;
        HashSet<String> hs = new HashSet<String>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            hs.add(nums[i]);
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        String[] result = { "" };
        solve(n, sb, hs, result);
        return result[0];
    }

    /**
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private void solve(int n, StringBuilder sb, HashSet<String> hs, String[] result) {
        // Base case
        if (sb.length() == n) {
            String str = sb.toString();
            if (!hs.contains(str)) {
                result[0] = str;
            }
            return;
        }
        for (char ch = '0'; ch <= '1'; ch++) {
            sb.append(ch); // do
            solve(n, sb, hs, result); // explore
            sb.setLength(sb.length() - 1); // undo - backtrack
        }
    }
}
