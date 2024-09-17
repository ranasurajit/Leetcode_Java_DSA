class Solution {
    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    public int firstUniqChar(String s) {
        int n = s.length();
        int index = -1;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
