class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Length) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        int k = p.length();
        int n = s.length();
        int[] chars = new int[26];
        for (int i = 0; i < k; i++) {
            chars[p.charAt(i) - 'a']++;
        }
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        while (j < n) { // TC: O(N)
            char ch = s.charAt(j);
            chars[ch - 'a']--;
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (isAnagram(chars)) { // TC: O(1)
                    result.add(i);
                }
                // remove computation from index 'i'
                chars[s.charAt(i) - 'a']++;
                // slide the window
                i++;
                j++;
            }
        }
        return result;
    }

    /**
     * TC: O(26) ~ O(1)
     * SC: O(1)
     */
    private boolean isAnagram(int[] chars) {
        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
