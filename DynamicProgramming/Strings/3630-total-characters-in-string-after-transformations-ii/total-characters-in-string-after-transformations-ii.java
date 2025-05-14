class Solution {
    private List<Integer> nums;
    private static final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] initialFreq = new int[26];
        for (char c : s.toCharArray()) {
            initialFreq[c - 'a']++;
        }
        
        int[][] transformationMatrix = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = i + 1; j <= i + nums.get(i); ++j) {
                transformationMatrix[j % 26][i]++;
            }
        }
        
        int[][] res = matrixExponentiation(transformationMatrix, t);
        int[] finalArray = new int[26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                finalArray[i] = (int)((finalArray[i] + (1L * res[i][j] * initialFreq[j]) % MOD) % MOD);
            }
        }
        
        int stringSize = 0;
        for (int i = 0; i < 26; ++i) {
            stringSize = (stringSize + finalArray[i]) % MOD;
        }
        return stringSize;
    }
    
    private int[][] matrixMultiplication(int[][] A, int[][] B) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                for (int k = 0; k < 26; ++k) {
                    res[i][j] = (int)((res[i][j] + (1L * A[i][k] * B[k][j]) % MOD) % MOD);
                }
            }
        }
        return res;
    }
    
    private int[][] matrixExponentiation(int[][] transformationMatrix, int t) {
        int[][] res = new int[26][26];
        // Create identity matrix
        for (int i = 0; i < 26; ++i) {
            res[i][i] = 1;
        }
        
        while (t > 0) {
            if ((t & 1) == 1) {
                res = matrixMultiplication(transformationMatrix, res);
            }
            transformationMatrix = matrixMultiplication(transformationMatrix, transformationMatrix);
            t >>= 1;
        }
        return res;
    }

    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N * F ^ T)
     * SC: O(N * F ^ T + T) ~ O(N * F ^ T)
     *
     * Memory Limit Exceeded (22 / 536 testcases passed)
     */
    public int lengthAfterTransformationsRecursionString(String s, int t, List<Integer> nums) {
        this.nums = nums;
        String result = solveRecursion(s, t);
        return result.length();
    }

    /**
     * Using Recursion Approach
     *
     * TC: O(N * F ^ T)
     * SC: O(N * F ^ T + T) ~ O(N * F ^ T)
     */
    private String solveRecursion(String s, int t) {
        // Base Case
        if (t == 0) {
            return s;
        }
        // Hypothesis
        String prev = solveRecursion(s, t - 1);
        // Induction
        StringBuilder sb = new StringBuilder(); // SC: O(25 ^ T)
        for (char ch : prev.toCharArray()) {
            int freq = nums.get(ch - 'a');
            for (int i = 1; i <= freq; i++) { // TC: O(26)
                int charIndex = ch - 'a';
                int newCharIndex = (charIndex + i) % 26;
                sb.append((char) ('a' + newCharIndex));
            }
        }
        return sb.toString();
    }
}
