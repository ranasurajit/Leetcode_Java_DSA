class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N), as the string size nearly doubles at each step in the worst case
     * SC: O(2 ^ N + N) ~ O(2 ^ N)
     */
    public String countAndSay(int n) {
        // Base Case
        if (n == 1) {
            return "1";
        }
        // Recursion Calls
        String say = countAndSay(n - 1);
        // process Run-length encoding
        return process(say); // TC: O(N), SC: O(N)
    }

    /**
     * Using a StringBuilder
     *
     * TC: O(N)
     * SC: O(N)
     */
    private String process(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int count = 1;
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
