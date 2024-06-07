class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> hs = new HashSet<String>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder rebuild = new StringBuilder();
        for (String word : words) {
            rebuild.append(findRoot(word, hs)).append(" ");
        }
        return rebuild.toString().trim();
    }

    private String findRoot(String word, Set<String> hs) {
        for (int i = 1; i < word.length(); i++) {
            String segment = word.substring(0, i);
            if (hs.contains(segment)) {
                return segment;
            }
        }
        return word;
    }
}
