class Solution {
    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(N ^ 2)
     */
    public int maximumLength(String s) {
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
