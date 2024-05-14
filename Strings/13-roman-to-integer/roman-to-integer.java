class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                num += 1;
            } else if (ch == 'V') {
                num += 5;
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    num -= 2;
                }
            } else if (ch == 'X') {
                num += 10;
                if (i > 0 && s.charAt(i - 1) == 'I') {
                    num -= 2;
                }
            } else if (ch == 'L') {
                num += 50;
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    num -= 20;
                }
            } else if (ch == 'C') {
                num += 100;
                if (i > 0 && s.charAt(i - 1) == 'X') {
                    num -= 20;
                }
            } else if (ch == 'D') {
                num += 500;
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    num -= 200;
                }
            } else if (ch == 'M') {
                num += 1000;
                if (i > 0 && s.charAt(i - 1) == 'C') {
                    num -= 200;
                }
            }
        }
        return num;
    }
}
