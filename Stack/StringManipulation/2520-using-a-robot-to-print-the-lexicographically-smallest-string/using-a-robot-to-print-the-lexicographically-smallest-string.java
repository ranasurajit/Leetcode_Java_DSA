class Solution {
    /**
     * Approach : Using Stack Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public String robotWithString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (char ch : s.toCharArray()) { // TC: O(N)
            st.push(ch);
            freq[ch - 'a']--;
            while (!st.isEmpty() && st.peek() <= getSmallestCharacter(freq)) { // TC: O(1)
                sb.append(st.pop());
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(26) ~ O(1)
     * SC: O(1)
     */
    private char getSmallestCharacter(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return (char) ('a' + i);
            }
        }
        return 'a';
    }
}
