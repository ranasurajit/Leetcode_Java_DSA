class Solution {
    /**
     * Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        int n = arr.length;
        if (n != pattern.length()) {
            return false;
        }
        int idx = 0;
        Map<Character, String> map = new HashMap<Character, String>(); // SC: O(N)
        Map<String, Character> revMap = new HashMap<String, Character>(); // SC: O(N)
        while (idx < n) { // TC: O(N)
            if (map.containsKey(pattern.charAt(idx)) && 
                !map.get(pattern.charAt(idx)).equals(arr[idx])) {
                return false;
            } else {
                if (revMap.containsKey(arr[idx]) && 
                    revMap.get(arr[idx]) != pattern.charAt(idx)) {
                    return false;
                }
                map.put(pattern.charAt(idx), arr[idx]);
                revMap.put(arr[idx], pattern.charAt(idx));
            }
            idx++;
        }
        return true;
    }
}
