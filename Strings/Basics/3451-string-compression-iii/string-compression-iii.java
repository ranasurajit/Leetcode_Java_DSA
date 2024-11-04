class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public String compressedString(String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder();
        char lastChar = word.charAt(0);
        int lastCount = 1;
        for (int i = 1; i < n; i++) {        // TC: O(N)
            if (word.charAt(i) == lastChar && lastCount < 9) {
                lastCount++;
            } else {
                sb.append(lastCount).append(lastChar);
                lastChar = word.charAt(i);
                lastCount = 1;
            }
        }
        sb.append(lastCount).append(lastChar);
        return sb.toString();
    }
}
