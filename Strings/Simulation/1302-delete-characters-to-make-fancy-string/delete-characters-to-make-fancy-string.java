class Solution {
    /**
     * Approach : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String makeFancyString(String s) {
        int n = s.length();
        if (n < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        sb.append(s.substring(0, 2));
        for (int i = 2; i < n; i++) { // TC: O(N)
            if (s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
