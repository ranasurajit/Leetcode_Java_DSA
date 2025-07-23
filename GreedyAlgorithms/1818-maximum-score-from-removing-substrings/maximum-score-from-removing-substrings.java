class Solution {
    /**
     * Using Greedy Algorithm + Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N), same memory will be reused
     */
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int[] maxScore = { 0 };
        char[] chars = s.toCharArray();
        if (x > y) {
            // we should remove "ab" first and then "ba"
            char[] result = removeSubstrings(chars, 'a', 'b', maxScore, x); // TC: O(N), SC: O(N)
            removeSubstrings(result, 'b', 'a', maxScore, y); // TC: O(N), SC: O(N)
        } else {
            // we should remove "ba" first and then "ab"
            char[] result = removeSubstrings(chars, 'b', 'a', maxScore, y); // TC: O(N), SC: O(N)
            removeSubstrings(result, 'a', 'b', maxScore, x); // TC: O(N), SC: O(N)
        }
        return maxScore[0];
    }

    /**
     * Using Stack Approach to Remove Substrings
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    private char[] removeSubstrings(char[] chars, char first, char second, int[] maxScore, int points) {
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (char ch : chars) { // TC: O(N)
            if (!st.isEmpty() && ch == second && st.peek() == first) {
                maxScore[0] += points;
                st.pop();
                continue;
            }
            st.push(ch);
        }
        int n = st.size();
        char[] result = new char[n];
        int index = n - 1;
        while (!st.isEmpty()) { // TC: O(N)
            result[index] = st.pop();
            index--;
        }
        return result;
    }
}
