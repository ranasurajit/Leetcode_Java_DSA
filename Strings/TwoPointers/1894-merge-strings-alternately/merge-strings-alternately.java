class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p = 0;
        int q = 0;
        int wLen1 = word1.length();
        int wLen2 = word2.length();
        String output = "";
        while (p < wLen1 && q < wLen2) {
            output += word1.charAt(p);
            output += word2.charAt(q);
            p++;
            q++;
        }
        // if word1 is still left untraversed
        while (p < wLen1) {
            output += word1.charAt(p);
            p++;
        }
        // if word2 is still left untraversed
        while (q < wLen2) {
            output += word2.charAt(q);
            q++;
        }
        return output;
    }
}
