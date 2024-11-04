class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char lastChar = '1';
        int lastCount = 0;
        for (int i = 0; i < word.length(); i++) {        // TC: O(N)
            char c = word.charAt(i);
            if (lastChar != c) {
                while (lastCount > 9) {
                    sb.append("9" + lastChar);
                    lastCount -= 9;
                }
                if (lastCount > 0) {
                    sb.append(lastCount + "" + lastChar);
                }
                lastCount = 1;
                lastChar = c;
            } else {
                lastCount++;
            }
        }
        while (lastCount > 9) {
            sb.append("9" + lastChar);
            lastCount -= 9;
        }
        sb.append(lastCount + "" + lastChar);
        return sb.toString();
    }
}
