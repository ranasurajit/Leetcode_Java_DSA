class Solution {
    /**
     * Using Stack
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        Stack<String> st = new Stack<String>(); // SC: O(N)
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (String word : words) { // TC: O(N)
            if (word != "") {
                st.push(word);
            }
        }
        while (!st.isEmpty()) { // TC: O(N)
            sb.append(st.pop() + " ");
        }
        return String.valueOf(sb).trim();
    }
}
