class Solution {
    private static final int MOD = 1000_000_007;
    /**
     * Approach II : Using Hashing Approach
     *
     * TC: O(N + T)
     * SC: O(2 x 26) ~ O(1)
     *
     * Accepted (824 / 824 testcases passed)
     */
    public int lengthAfterTransformations(String s, int t) {
        int[] map = new int[26]; // SC: O(26)
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            map[s.charAt(i) - 'a']++;
        }
        for (int count = 0; count < t; count++) { // TC: O(T)
            int[] temp = new int[26]; // SC: O(26)
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                int freq = map[i];
                if (ch != 'z') {
                    temp[(ch + 1) - 'a'] = (temp[(ch + 1) - 'a'] + freq) % MOD;
                } else {
                    temp[0] = (freq + temp[0]) % MOD;
                    temp[1] = (freq + temp[1]) % MOD;
                }
            }
            map = temp;
        }
        int length = 0;
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            length = (length + (map[i] % MOD)) % MOD;
        }
        return length % MOD;
    }

    /**
     * Approach I : Using StringBuilder Approach
     *
     * TC: O(T x N)
     * SC: O(2 x L) where L = final length of String
     *
     * Time Limit Exceeded (502 / 824 testcases passed)
     */
    public int lengthAfterTransformationsApproachI(String s, int t) {
        int count = 0;
        while (count < t) {
            StringBuilder sb = new StringBuilder();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] != 'z') {
                    sb.append((char) (ch[i] + 1));
                } else {
                    sb.append('a');
                    sb.append('b');
                }
            }
            s = sb.toString();
            count++;
        }
        return s.length();
    }
}
