class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public long minimumSteps(String s) {
        int n = s.length();
        int countBlacks = 0;
        long steps = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (s.charAt(i) == '1') {
                countBlacks++;
            } else {
                steps += (long) countBlacks;
            }
        }
        return steps;
    }
}
