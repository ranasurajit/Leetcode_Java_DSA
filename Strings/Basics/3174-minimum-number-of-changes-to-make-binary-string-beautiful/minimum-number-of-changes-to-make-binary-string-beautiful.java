class Solution {
    /**
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public int minChanges(String s) {
        int changes = 0;
        for (int i = 1; i < s.length(); i = i + 2) {                // TC: O(N / 2)
            if (s.charAt(i) != s.charAt(i - 1)) {
                changes++;
            }
        }
        return changes;
    }

    /**
     * TC: O(3N / 2) ~ O(N)
     * SC: O(N)
     */
    public int minChangesNotEfficient(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();                   // SC: O(N)
        for (int i = 1; i < n; i = i + 2) {               // TC: O(N / 2)
            String evenSub = chars[i - 1] + "" + chars[i];
            if (evenSub.equals("00") || evenSub.equals("11")) {
                chars[i - 1] = 'x';
                chars[i] = 'x';
            }
        }
        int count0s = 0;
        int count1s = 0;
        for (int i = 0; i < n; i++) {                     // TC: O(N)
            if (chars[i] == '0') {
                count0s++;
            } else if (chars[i] == '1') {
                count1s++;
            }
        }
        return Math.min(count0s, count1s);
    }
}
