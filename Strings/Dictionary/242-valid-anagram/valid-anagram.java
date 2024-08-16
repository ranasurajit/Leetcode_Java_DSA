class Solution {

    /**
     * Using Constant Space
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Using HashMap
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     Map<Character, Integer> hm = new HashMap<Character, Integer>();
    //     for (int i = 0; i < s.length(); i++) {
    //         hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
    //     }
    //     for (int i = 0; i < t.length(); i++) {
    //         if (hm.containsKey(t.charAt(i))) {
    //             int count = hm.get(t.charAt(i));
    //             if (count == 1) {
    //                 hm.remove(t.charAt(i));
    //             } else {
    //                 hm.put(t.charAt(i), count - 1);
    //             }
    //         }
    //     }
    //     return hm.isEmpty();
    // }

    /**
     * Using Sorting
     */
    // public boolean isAnagram(String s, String t) {
    //     if (s.length() != t.length()) {
    //         return false;
    //     }
    //     char[] sch = s.toCharArray();
    //     char[] tch = t.toCharArray();
    //     Arrays.sort(sch);
    //     Arrays.sort(tch);
    //     for (int i = 0; i < sch.length; i++) {
    //         if (sch[i] != tch[i]) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
}
