class Solution {
    public int minChanges(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 1; i < n; i = i + 2) {
            String evenSub = chars[i - 1] + "" + chars[i];
            if (evenSub.equals("00") || evenSub.equals("11")) {
                chars[i - 1] = 'x';
                chars[i] = 'x';
            }
        }
        int count0s = 0;
        int count1s = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '0') {
                count0s++;
            } else if (chars[i] == '1') {
                count1s++;
            }
        }
        return Math.min(count0s, count1s);
    }
}
