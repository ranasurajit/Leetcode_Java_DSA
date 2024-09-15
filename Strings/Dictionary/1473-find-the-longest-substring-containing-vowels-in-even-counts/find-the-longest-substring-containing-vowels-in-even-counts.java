class Solution {
    public int findTheLongestSubstring(String s) {
        // SC: O(2^5) = O(32) ~ O(1) (we need 5 bits and has 0 or 1 value so total states = 2 ^ 5 = 32) 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int mask = 0; // 00000 representing  - u o i e a (vowels)
        hm.put(mask, -1);
        int result = 0;
        // TC: O(N)
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                mask = mask ^ (1 << 0);
            } else if (s.charAt(i) == 'e') {
                mask = mask ^ (1 << 1);
            } else if (s.charAt(i) == 'i') {
                mask = mask ^ (1 << 2);
            } else if (s.charAt(i) == 'o') {
                mask = mask ^ (1 << 3);
            } else if (s.charAt(i) == 'u') {
                mask = mask ^ (1 << 4);
            }
            // check if we already saw the same bits earlier in HashMap
            if (hm.containsKey(mask)) {
                result = Math.max(result, i - hm.get(mask));
            } else {
                hm.put(mask, i);
            }
        }
        return result;
    }
}
