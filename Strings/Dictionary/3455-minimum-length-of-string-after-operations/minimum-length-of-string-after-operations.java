class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        Map<Character, ArrayList<Integer>> map = 
            new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<Integer>());
            }
            map.get(ch).add(i);
        }
        int minLength = 0;
        for (Character key : map.keySet()) {
            int size = map.get(key).size();
            if (size > 2) {
                minLength += size % 2 == 0 ? 2 : 1;
            } else {
                minLength += size;
            }
        }
        return minLength;
    }
}
