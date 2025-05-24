class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(3 x N + M) ~ O(N + M)
     *
     * where M = Length(s)
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // TC: O(N), SC: O(N + M)
        if (pattern.length() != words.length) {
            // impossible to match
            return false;
        }
        Map<String, Character> wordMap = new HashMap<String, Character>(); // SC: O(N)
        Set<Character> usedSet = new HashSet<Character>(); // SC: O(N)
        int index = 0;
        while (index < words.length) { // TC: O(N)
            if (!wordMap.containsKey(words[index]) && !usedSet.contains(pattern.charAt(index))) {
                wordMap.put(words[index], pattern.charAt(index));
                usedSet.add(pattern.charAt(index));
            } else {
                if (!wordMap.containsKey(words[index]) &&
                    usedSet.contains(pattern.charAt(index))) {
                    return false;
                } else if (wordMap.containsKey(words[index]) &&
                    wordMap.get(words[index]) != pattern.charAt(index)) {
                    return false;
                }
            }
            index++;
        }
        return true;
    }
}
