class Solution {
    /**
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public int minChanges(String s) {
        int n = s.length();
        int changes = 0;
        for (int i = 1; i < n; i = i + 2) {                // TC: O(N / 2)
            if (s.charAt(i) != s.charAt(i - 1)) {
                changes++;
            }
        }
        return changes;
    }
}
