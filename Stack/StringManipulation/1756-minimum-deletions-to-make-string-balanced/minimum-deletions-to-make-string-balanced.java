class Solution {

    /**
     * Using Two Pointers - TC: O(N), SC: O(1)
     */
    public int minimumDeletions(String s) {
        int n = s.length();
        int minCount = Integer.MAX_VALUE;
        int leftB = 0;
        int rightA = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                rightA--;
            }
            minCount = Math.min(minCount, rightA + leftB);
            if (s.charAt(i) == 'b') {
                leftB++;
            }
        }
        return minCount;
    }

    /**
     * Using Stack - TC: O(N), SC: O(N)
     */
    public int minimumDeletionsUsingStack(String s) {
        int n = s.length();
        int count = 0;
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            if (!st.isEmpty() && s.charAt(i) == 'a' && st.peek() == 'b') {
                st.pop();
                count++;
            } else {
                st.push(s.charAt(i));
            }
        }
        return count;
    }
}
