class Solution {
    public int scoreOfString(String s) {
        int score = 0;
        int n = s.length() - 1;
        while (n > 0) {
            int current = s.charAt(n);
            int prev = s.charAt(n - 1);
            score += Math.abs(current - prev);
            n--;
        }
        return score;
    }
}
