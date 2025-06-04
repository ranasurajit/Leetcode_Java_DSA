class Solution {
    /**
     * Approach : Using String Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        int k = n - (numFriends - 1);
        String maxStr = "";
        for (int i = 0; i < n; i++) { // TC: O(N)
            String current = word.substring(i, Math.min(n, k + i)); // TC: O(N)
            if (maxStr.compareTo(current) < 0) {
                maxStr = current;
            }
        }
        return maxStr;
    }
}
