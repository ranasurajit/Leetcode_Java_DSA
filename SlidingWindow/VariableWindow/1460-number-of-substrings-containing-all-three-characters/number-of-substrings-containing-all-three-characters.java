class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(K)
     * 
     * @param s
     * @param n
     * @param k
     * @return
     */
    public int numberOfSubstrings(String s) {
        int n = s.length();
        return countSubstringsLessThanEqualsK(s, n, 3) - countSubstringsLessThanEqualsK(s, n, 2);
    }

    /**
     * Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(N)
     * SC: O(K)
     * 
     * @param s
     * @param n
     * @param k
     * @return
     */
    private int countSubstringsLessThanEqualsK(String s, int n, int k) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(K)
        int count = 0;
        while (j < n) { // TC: O(N)
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > k) {
                // remove computation from index 'i'
                int freq = map.get(s.charAt(i));
                if (freq == 1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), freq - 1);
                }
                i++;
            }
            count += (j - i + 1);
            j++;
        }
        return count;
    }
}
