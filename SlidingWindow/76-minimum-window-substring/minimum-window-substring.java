class Solution {
    /**
     * TC: O(M + N)
     * SC: O(N)
     */
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return "";
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        int requiredCount = n;
        int minWindowSize = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0, j = 0; j < m; j++) { // TC: O(M)
            char ch = s.charAt(j);
            if (hm.containsKey(ch) && hm.get(ch) > 0) {
                requiredCount--;
            }
            hm.put(ch, hm.getOrDefault(ch, 0) - 1);
            while (requiredCount == 0) {
                int currWindowSize = j - i + 1;
                if (currWindowSize < minWindowSize) {
                    minWindowSize = currWindowSize;
                    start = i;
                }
                // shrink the window size
                char startChar = s.charAt(i);
                hm.put(startChar, hm.getOrDefault(startChar, 0) + 1);
                if (hm.containsKey(startChar) && hm.get(startChar) > 0) {
                    requiredCount++;
                }
                i++;
            }
        }
        return minWindowSize == Integer.MAX_VALUE ? 
            "" : s.substring(start, start + minWindowSize);
    }
}
