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
            char c = word.charAt(i);
            if (c == lastChar && lastCount < 9) {
                lastCount++;
            } else {
                sb.append(lastCount).append(lastChar);
                lastChar = c;
                lastCount = 1;
            }
        }
        sb.append(lastCount).append(lastChar);
        return sb.toString();
    }
}
