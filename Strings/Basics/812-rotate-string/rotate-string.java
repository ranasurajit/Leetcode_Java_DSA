class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }
        if (!(s + s).contains(goal)) {
            return false;
        }
        return true;
    }
}
