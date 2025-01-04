class Solution {
    /**
     * Using Property of Length-3 Palindromic String
     * 
     * TC: O(N + K)
     * SC: O(2 ^ N)
     */
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[][] alpha = new int[26][2];                     // SC: O(52)
        for (int[] occur : alpha) {                         // TC: O(52)
            Arrays.fill(occur, -1);
        }
        for (int i = 0; i < n; i++) {                       // TC: O(N)
            int charIndex = s.charAt(i) - 'a';
            if (alpha[charIndex][0] == -1) {
                alpha[charIndex][0] = i;
            } else {
                alpha[charIndex][1] = i;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {                      // TC: O(26)
            if (alpha[i][0] != -1) {
                Set<Character> set = new HashSet<Character>();
                int min = alpha[i][0];
                int max = alpha[i][1];
                for (int j = min + 1; j <= max - 1; j++) {  // TC: O(K)
                    set.add(s.charAt(j));
                }
                count += set.size();
            }
        }
        return count;
    }

    public int countPalindromicSubsequenceRecursion(String s) {
        int n = s.length();
        Set<String> subSeq = new HashSet<String>();
        solveRecursion(0, s, n, "", subSeq);
        return subSeq.size();
    }

    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     */
    private void solveRecursion(int index, String s, int n, 
        String current, Set<String> subSeq) {
        // base case
        if (index == n) {
            if (current.length() == 3 && current.charAt(0) == current.charAt(2)) {
                subSeq.add(current);
            }
            return;
        }
        // include current index from String 's'
        solveRecursion(index + 1, s, n, current + String.valueOf(s.charAt(index)), subSeq);
        // don't include current index from String 's'
        solveRecursion(index + 1, s, n, current, subSeq);
    }
}
