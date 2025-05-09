class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(2 x K) ~ O(K)
     * SC: O(1)
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int max = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < k; i++) { // TC: O(K)
            leftSum += cardPoints[i];
        }
        max = leftSum;
        int p = k - 1; // left pointer
        int q = n - 1; // right pointer
        while (k > 0 && p >= 0 && q >= 0) { // TC: O(K)
            leftSum -= cardPoints[p];
            rightSum += cardPoints[q];
            p--;
            q--;
            k--;
            max = Math.max(max, leftSum + rightSum);
        }
        return max;
    }
}
