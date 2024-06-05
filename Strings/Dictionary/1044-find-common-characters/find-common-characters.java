class Solution {
    public List<String> commonChars(String[] words) {
        int[] commonchars = new int[26];
        Arrays.fill(commonchars, Integer.MAX_VALUE);
        List<String> commonList = new ArrayList<String>();
        for (String word : words) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }
            for (int i = 0; i < freq.length; i++) {
                commonchars[i] = Math.min(commonchars[i], freq[i]);
            }
        }
        for (int i = 0; i < commonchars.length; i++) {
            for (int j = 0; j < commonchars[i]; j++) {
                commonList.add(String.valueOf((char) (97 + i)));
            }
        }
        return commonList;
    }
}
