class Solution {
    /**
     * Using Backtracking Approach
     *
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public String findDifferentBinaryString(String[] nums) {
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
