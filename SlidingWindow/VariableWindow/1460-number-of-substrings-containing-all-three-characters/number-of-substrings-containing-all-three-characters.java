class Solution {
    /**
     * using Sliding Window (Variable Size) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(3)
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int count = 0;
        while (j < n) { // TC: O(N)
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == 3) {
                /**
                 * as when sliding window is met we can include
                 * all characters till n i.e. total count for a 
                 * pair (i, j) = (n - j)
                 */
                count += (n - j);
                // shrink the window
                char ci = s.charAt(i);
                int freq = map.get(ci);
                if (freq == 1) {
                    map.remove(ci);
                } else {
                    map.put(ci, freq - 1);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
