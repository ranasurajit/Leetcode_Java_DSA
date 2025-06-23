class Solution {
    /**
     * Using Optimal (Palindrome Number Generation + Two Pointers) Approach
     *
     * TC: O(N x (L + log(L) base K)), , where L = maximum number of digits
     * SC: O(1)
     *
     * Accepted (97 / 97 testcases passed)
     */
    public long kMirror(int k, int n) {
        long sum = 0L;
        int L = 1;
        while (n > 0) { // TC: O(N)
            int halfLength = (L + 1) / 2;
            int minNum = (int) Math.pow(10, halfLength - 1);
            int maxNum = (int) Math.pow(10, halfLength) - 1;
            for (int i = minNum; i <= maxNum; i++) {
                String firstHalf = String.valueOf(i);
                String secondHalf = reverse(firstHalf); // TC: O(L / 2)
                if (L % 2 == 1) {
                    // odd length
                    secondHalf = reverse(firstHalf).substring(1);
                }
                String palindromeDec = firstHalf + secondHalf;
                long palindromeNum = Long.valueOf(palindromeDec);
                String baseKNum = convertReverseToBaseK(palindromeNum, k); // TC: O(log(L) base K)
                if (isPalindrome(String.valueOf(baseKNum))) { // TC: O(L / 2)
                    sum += palindromeNum;
                    n--;
                    if (n == 0) {
                        break;
                    }
                }
            }
            L++;
        }
        return sum;
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(L)
     * SC: O(1)
     */
    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }

    /**
     * Using Brute-Force (Simulation + Two Pointers) Approach
     *
     * TC: O(N x L x log(L) base K), where L = maximum number of digits
     * SC: O(1)
     *
     * Time Limit Exceeded (73 / 97 testcases passed)
     */
    public long kMirrorBruteForce(int k, int n) {
        long sum = 0L;
        for (int i = 1; i < Integer.MAX_VALUE && n > 0; i++) { // TC: O(N)
            if (isPalindrome(String.valueOf(i)) && 
                isPalindrome(convertReverseToBaseK(i, k))) { // TC: O(L x log(L) Base K)
                sum += i;
                n--;
            }
        }
        return sum;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(log(L) base K)
     * SC: O(1)
     */
    private String convertReverseToBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num = num / k;
        }
        return sb.toString();
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(L / 2)
     * SC: O(1)
     */
    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
