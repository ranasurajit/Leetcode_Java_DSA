class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if ((str1 + str2).equals(str2 + str1)) {
            int len1 = str1.length();
            int len2 = str2.length();
            int gcd = getGCD(len1, len2);
            return str1.substring(0, gcd);
        } else {
            return "";
        }
    }

    private int getGCD(int a, int b) {
        while (a % b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return b;
    }
}
