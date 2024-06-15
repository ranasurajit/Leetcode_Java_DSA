class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<String>();
        for (String word : words) {
            if (word != "") {
                st.add(word);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }
        return sb.toString().trim();
    }
}
