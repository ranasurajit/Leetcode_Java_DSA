class Solution {
    /**
     * Approach II : Using Hashing Approach (Clean Approach)
     * 
     * TC: O(N)
     * SC: O(2 x 257) ~ O(1)
     */
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[257]; // as ASCII characters are 256
        int[] tMap = new int[257]; // as ASCII characters are 256
        for (int i = 0; i < s.length(); i++) {
            if (sMap[(int) s.charAt(i)] != tMap[(int) t.charAt(i)]) {
                return false;
            }
            sMap[(int) s.charAt(i)] = i + 1;
            tMap[(int) t.charAt(i)] = i + 1;
        }
        return true;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public boolean isIsomorphicApproachI(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>(); // SC: O(N)
        Map<Character, Character> revMap = new HashMap<Character, Character>(); // SC: O(N)
        int n = s.length();
        for (int i = 0; i < n; i++) { // TC: O(N)
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            if (map.containsKey(sch) && map.get(sch) != tch) {
                return false;
            } else {
                if (revMap.containsKey(tch) && revMap.get(tch) != sch) {
                    return false;
                }
                map.put(sch, tch);
                revMap.put(tch, sch);
            }
        }
        return true;
    }
}
