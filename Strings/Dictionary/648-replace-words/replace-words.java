class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> hs = new HashSet<String>();
        for (String s : dictionary) {
            hs.add(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder rebuild = new StringBuilder();
        for (int p = 0; p < words.length; p++) {
            StringBuilder sb = new StringBuilder();
            boolean match = false;
            for (int i = 0; i < words[p].length(); i++) {
                sb.append(words[p].charAt(i));
                String current = sb.toString();
                if (hs.contains(current)) {
                    rebuild.append(current);
                    match = true;
                    break;
                }
            }
            if (!match) {
                rebuild.append(words[p]);
            }
            if (p < words.length - 1) {
                rebuild.append(" ");
            }
        }
        return rebuild.toString();
    }
}
