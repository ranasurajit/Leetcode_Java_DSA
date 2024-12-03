class Solution {

    /**
     * Optimal Approach (Using Two Pointers)
     *
     * TC: O(N)
     * SC: O(N + M)
     */
    public String addSpaces(String s, int[] spaces) {
        int n = s.length();
        int m = spaces.length;
        int p = 0; // pointer for String s
        int q = 0; // pointer for array 'spaces'
        StringBuilder sb = new StringBuilder(); // SC: O(N + M)
        while (p < n && q < m) {                // TC: O(N)
            if (p == spaces[q]) {
                sb.append(" ");
                q++;
            }
            sb.append(s.charAt(p));
            p++;
        }
        while (p < n) {
            sb.append(s.charAt(p));
            p++;
        }
        return sb.toString();
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(M x N)
     * SC: O(N)
     */
    public String addSpacesBruteForce(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s); // SC: O(N)
        int spaceCount = 0;
        for (int space : spaces) { // TC: O(M)
            sb.insert(spaceCount + space, " "); // TC: O(N)
            spaceCount++;
        }
        return sb.toString();
    }
}
