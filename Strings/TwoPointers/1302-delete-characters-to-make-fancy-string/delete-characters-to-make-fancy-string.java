class Solution {
    /**
     * Optimized Approach
     * TC: O(N)
     * SC: O(N)
     */
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) { // TC: O(N), SC: O(N)
            int n = sb.length();
            if (n < 2 || !(sb.charAt(n - 1) == ch && sb.charAt(n - 2) == ch)) {
                sb.append(ch); // TC: O(1)
            }
        }
        return sb.toString();
    }
}
