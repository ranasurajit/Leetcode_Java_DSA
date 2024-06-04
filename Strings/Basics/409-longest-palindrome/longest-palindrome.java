class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        Set<Character> hs = new HashSet<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (hs.contains(chars[i])) {
                length += 2;
                hs.remove(chars[i]);
            } else {
                hs.add(chars[i]);
            }
        }
        return hs.size() > 0 ? length + 1 : length;
    }
}
