class Solution {
    /**
     * TC: O(2K + 2K x N) ~ O(K x N), where K = length of each words
     * SC: O(2K) ~ O(K)
     * 
     * @param words
     * @return
     */
    public List<String> commonChars(String[] words) {
        List<String> common = new ArrayList<String>();
        String word = words[0];
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(K)
        for (int i = 0; i < word.length(); i++) { // TC: O(K)
            hm.put(word.charAt(i), hm.getOrDefault(word.charAt(i), 0) + 1);
        }
        for (int i = 1; i < words.length; i++) { // TC: O(N)
            HashMap<Character, Integer> dup = new HashMap<Character, Integer>(); // SC: O(K)
            String currentWord = words[i];
            for (int j = 0; j < currentWord.length(); j++) { // TC: O(K)
                dup.put(currentWord.charAt(j), dup.getOrDefault(currentWord.charAt(j), 0) + 1);
            }
            for (Character key : hm.keySet()) { // TC: O(K)
                if (dup.containsKey(key)) {
                    hm.put(key, Math.min(hm.get(key), dup.get(key)));
                } else {
                    hm.put(key, 0);
                }
            }
        }
        for (Character key : hm.keySet()) {
            if (hm.get(key) > 0) {
                for (int i = 0; i < hm.get(key); i++) {
                    common.add(String.valueOf(key));
                }
            }
        }
        return common;
    }
}
