class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int count = 0;
        while (count < s.length()) {
            if (s.charAt(count) == 'M') {
                num += 1000;
            } else if (s.charAt(count) == 'D') {
                num += 500;
            } else if (s.charAt(count) == 'C' && (count + 1) < s.length() && (s.charAt(count + 1) == 'D' || s.charAt(count + 1) == 'M')) {
                num -= 100;
            } else if (s.charAt(count) == 'C') {
                num += 100;
            } else if (s.charAt(count) == 'L') {
                num += 50;
            } else if (s.charAt(count) == 'X' && (count + 1) < s.length() && (s.charAt(count + 1) == 'L' || s.charAt(count + 1) == 'C')) {
                num -= 10;
            } else if (s.charAt(count) == 'X') {
                num += 10;
            } else if (s.charAt(count) == 'V') {
                num += 5;
            } else if (s.charAt(count) == 'I' && (count + 1) < s.length() && (s.charAt(count + 1) == 'X' || s.charAt(count + 1) == 'V')) {
                num -= 1;
            } else if (s.charAt(count) == 'I') {
                num += 1;
            }
            count++;
        }
        return num;
    }
}