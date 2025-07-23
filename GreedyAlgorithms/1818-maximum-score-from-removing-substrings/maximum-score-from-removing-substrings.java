class Solution {
    /**
     * Approach I : Using Greedy Algorithm + Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N), same memory will be reused
     */
    public int maximumGain(String s, int x, int y) {
        int[] maxScore = { 0 };
        char[] chars = s.toCharArray();
        char[] subAB = { 'a', 'b' };
        char[] subBA = { 'b', 'a' };
        if (x > y) {
            // we should remove "ab" first and then "ba"
            char[] result = removeSubstrings(chars, subAB, maxScore, x); // TC: O(N), SC: O(N)
            removeSubstrings(result, subBA, maxScore, y); // TC: O(N), SC: O(N)
        } else {
            // we should remove "ba" first and then "ab"
            char[] result = removeSubstrings(chars, subBA, maxScore, y); // TC: O(N), SC: O(N)
            removeSubstrings(result, subAB, maxScore, x); // TC: O(N), SC: O(N)
        }
        return maxScore[0];
    }

    /**
     * Using Stack Approach to Remove Substrings
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    private char[] removeSubstrings(char[] chars, char[] sub, int[] maxScore, int points) {
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (char ch : chars) { // TC: O(N)
            if (!st.isEmpty() && ch == sub[1] && st.peek() == sub[0]) {
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
