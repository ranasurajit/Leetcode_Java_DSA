class Solution {
    public int longestPalindrome(String s) {
        int length = 0;
        Set<Character> hs = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hs.contains(ch)) {
                length += 2;
                hs.remove(ch);
            } else {
                hs.add(ch);
            }
        }
        return hs.size() > 0 ? length + 1 : length;
    }
}
