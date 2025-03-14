class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p = 0;
        int q = 0;
        int wLen1 = word1.length();
        int wLen2 = word2.length();
        StringBuilder builder = new StringBuilder();
        while (p < wLen1 || q < wLen2) {
            if (p < wLen1) {
                builder.append(word1.charAt(p));
                p++;
            }
            if (q < wLen2) {
                builder.append(word2.charAt(q));
                q++;
            }
        }
        return builder.toString();
    }
}
