class Solution {
    /**
     * TC: O(N + K)
     * SC: O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int[] chars = new int[26];
        for (int i = 0; i < k; i++) { // TC: O(K)
            chars[p.charAt(i) - 'a']++;
        }
        List<Integer> indices = new ArrayList<Integer>();
        int n = s.length();
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            chars[s.charAt(j) - 'a']--;
            if (j - i + 1 == k) {
                if (containsAllZeros(chars)) { // TC: O(26)
                    indices.add(i);
                }
                chars[s.charAt(i) - 'a']++;
                i++;
            }
        }
        return indices;
    }

    /**
     * TC: O(26)
     * SC: O(1)
     */
    private boolean containsAllZeros(int[] chars) {
        for (int it : chars) {
            if (it != 0) {
                return false;
            }
        }
        return true;
    }
}
