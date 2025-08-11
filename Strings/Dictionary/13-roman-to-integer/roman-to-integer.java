class Solution {
    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int romanToInt(String s) {
        int n = s.length();
        Map<Character, Integer> map = getMappings(); // TC: O(7), SC: O(7)
        int result = map.get(s.charAt(0));
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    /**
     * Using Hashing Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    private Map<Character, Integer> getMappings() {
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(7) ~ SC: O(1)
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
