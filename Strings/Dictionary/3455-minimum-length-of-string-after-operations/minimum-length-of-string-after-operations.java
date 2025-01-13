class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        Map<Character, Integer> map = 
            new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int minLength = 0;
        for (Character key : map.keySet()) {
            int size = map.get(key);
            if (size > 2) {
                minLength += size % 2 == 0 ? 2 : 1;
            } else {
                minLength += size;
            }
        }
        return minLength;
    }
}
