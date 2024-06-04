class Solution {
    public int longestPalindrome(String s) {
        int even = 0;
        int odd = 0;
        boolean hasOdd = false;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int count = entry.getValue();
            odd = count % 2;
            even += count - odd;
        }
        return even < s.length() ? even + 1 : even;
    }
}
