class Solution {
    /**
     * Brute-Force Approach
     *
     * TC: O(M x N)
     * SC: O(N)
     */
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s); // SC: O(N)
        int spaceCount = 0;
        for (int space : spaces) { // TC: O(M)
            sb.insert(spaceCount + space, " "); // TC: O(N)
            spaceCount++;
        }
        return sb.toString();
    }
}
