class Solution {
    public String removeOccurrences(String s, String part) {
        int m = s.length();
        int n = part.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) { // TC: O(M)
            sb.append(s.charAt(i));
            int startIndex = sb.length() - n;
            int len = sb.length();
            if (len >= n && sb.substring(startIndex, len).toString().equals(part)) {
                sb.setLength(sb.length() - n);
            }
        }
        return sb.toString();
    }
}
