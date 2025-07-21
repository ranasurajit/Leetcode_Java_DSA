class Solution {
    /**
     * Approach II : Using String Simulation + Array Conversion Approach
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
        char[] sch = s.toCharArray(); // SC: O(N)
        sb.append(sch[0]).append(sch[1]);
        for (int i = 2; i < n; i++) { // TC: O(N)
            if (sch[i - 2] == sch[i - 1] && sch[i] == sch[i - 1]) {
                continue;
            }
            sb.append(sch[i]);
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
