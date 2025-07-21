class Solution {
    /**
     * Approach II : Using String Simulation (Cleaner) Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (char ch : s.toCharArray()) { // TC: O(N)
            int n = sb.length();
            if (n < 2 || !(ch == sb.charAt(n - 2) && ch == sb.charAt(n - 1))) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * Approach I : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public String makeFancyStringSimulation(String s) {
        int n = s.length();
        if (n < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        sb.append(s.charAt(0)).append(s.charAt(1));
        for (int i = 2; i < n; i++) { // TC: O(N)
            if (s.charAt(i - 2) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
