class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            // all characters of String 't' cannot be present in String 's'
            return "";
        }
        // storing the frequency of all characters in String 't' in HashMap
        Map<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        // storing count of minimum elements needed in String 's'
        int count = hm.size();
        int i = 0; // start index of sliding window
        int j = 0; // end index of sliding window
        int start = 0; // to store the starting index of our minimum window Substring
        int minLength = Integer.MAX_VALUE; // length of minimum window Substring
        while (j < m) { // TC: O(M)
            char ch = s.charAt(j);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.getOrDefault(ch, 0) - 1);
                if (hm.get(ch) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                int currentWindowSize = j - i + 1;
                if (currentWindowSize < minLength) {
                    // capturing the minimum sliding window size and start index of it
                    minLength = currentWindowSize;
                    start = i;
                }
                // shrinking the window size so as to capture minimum sliding window size
                char rch = s.charAt(i);
                // removing calculation of character at index i before incrementing 'i'
                if (hm.containsKey(rch)) {
                    hm.put(rch, hm.getOrDefault(rch, 0) + 1);
                    if (hm.get(rch) > 0) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
