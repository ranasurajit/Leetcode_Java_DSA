class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     * 
     * Accepted - Test Cases Passed: (1112 /1112)
     */
    public int minimumPushes(String word) {
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
