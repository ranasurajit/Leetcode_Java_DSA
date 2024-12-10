class Solution {
    /**
     * Better Approach
     *
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     */
    public int maximumLength(String s) {
        int n = s.length();
        HashMap<Pair<Character, Integer>, Integer> hm =
            new HashMap<Pair<Character, Integer>, Integer>();
        int len = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            char current = s.charAt(i);
            len = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                if (current == s.charAt(j)) {
                    len++;
                    Pair<Character, Integer> pair = 
                        new Pair<Character, Integer>(current, len);
                    hm.put(pair, hm.getOrDefault(pair, 0) + 1);
                } else {
                    break;
                }
            }
        }
        int maxLength = -1;
        // TC: O(N)
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : hm.entrySet()) {
            Pair<Character, Integer> currentKey = entry.getKey();
            if (hm.get(currentKey) >= 3) {
                int currentLength = currentKey.getValue(); // access length from Pair
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(N ^ 2)
     */
    public int maximumLengthBruteForce(String s) {
        int n = s.length();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {     // TC: O(N)
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) { // TC: O(N)
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) == s.charAt(j)) {
                    sb.append(s.charAt(j));
                    // TC: O(N)
                    hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
                } else {
                    break;
                }
            }
        }
        int maxLength = -1;
        for (String key : hm.keySet()) {  // TC: O(N)
            if (hm.get(key) >= 3) {
                maxLength = Math.max(maxLength, key.length());
            }
        }
        return maxLength;
    }
}
