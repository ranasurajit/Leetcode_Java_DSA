class Solution {
    /**
     * Using StringBuilder
     *
     * TC: O(M x N)
     * SC: O(M)
     */
    public String removeOccurrences(String s, String part) {
        int m = s.length();
        int n = part.length();
        StringBuilder sb = new StringBuilder(); // SC: O(M)
        for (int i = 0; i < m; i++) { // TC: O(M)
            sb.append(s.charAt(i));
            if (sb.length() >= n && 
                sb.substring(sb.length() - n, sb.length()).toString().equals(part)) { 
                // TC: O(N)
                sb.setLength(sb.length() - n);
            }
        }
        return sb.toString();
    }
}
