class Solution {
    /**
     * Approach II : Using Hashing Approach (Cleaner Approach)
     * 
     * TC: O(N)
     * SC: O(26) ~ O(1)
     */
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26]; // SC: O(26)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[word.charAt(i) - 'a']++;
        }
        int pushes = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) { // TC: O(N)
            if (freq[i] > 0) {
                pushes += (count / 8) + 1;
                count++;
            }
        }
        return pushes;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int minimumPushesApproachI(String word) {
        int n = word.length();
        // we will store { Characters, freq } in HashMap
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int size = map.size();
        int pushes = 0;
        int places = 8; // we have keys 2-9 to re-map the Characters
        int tap = 1;
        while (size > 0) { // TC: O(N)
            int slab = Math.min(places, size);
            pushes += tap * slab;
            size = size - slab;
            tap++;
        }
        return pushes;
    }
}
