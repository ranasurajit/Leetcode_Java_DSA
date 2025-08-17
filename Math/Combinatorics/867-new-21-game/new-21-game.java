class Solution {
    /**
     * Approach II : Using Optimal (Math + Probability) Approach
     *
     * TC: O(N) + O(N - K) ~ O(N)
     * SC: O(N)
     *
     * Accepted (151 / 151 testcases passed)
     */
    public double new21Game(int n, int k, int maxPts) {
        double[] p = new double[n + 1]; // SC: O(N)
        p[0] = 1.0; // at the start Alice had started with 0 points so probability is 1
        /**
         * if n = 21, maxPoints = 10 and k = 17 we need to find
         * p(21) + p(20) + p(19) + p(18) + p(17) as at k = 17, 
         * the game stops and for anything less than k, the game 
         * will continue
         */
        double currentProbSum = k > 0 ? 1.0 : 0.0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            p[i] = currentProbSum / maxPts;
            if (i < k) {
                currentProbSum += p[i];
            }
            if (i - maxPts >= 0 && i - maxPts < k) {
                currentProbSum -= p[i - maxPts];
            }
        }
        double probabilitySum = 0.0;
        for (int i = k; i <= n; i++) { // TC: O(N - K)
            probabilitySum += p[i];
        }
        return probabilitySum;
    }

    /**
     * Approach I : Using Brute-Force (Math + Probability) Approach
     *
     * TC: O(N x maxPts)
     * SC: O(N)
     *
     * Time Limit Exceeded (107 / 151 testcases passed)
     */
    public double new21GameBruteForce(int n, int k, int maxPts) {
        double[] p = new double[n + 1]; // SC: O(N)
        p[0] = 1.0; // at the start Alice had started with 0 points so probability is 1
        /**
         * if n = 21, maxPoints = 10 and k = 17 we need to find
         * p(21) + p(20) + p(19) + p(18) + p(17) as at k = 17, 
         * the game stops and for anything less than k, the game 
         * will continue
         */
        for (int i = 1; i <= n; i++) { // TC: O(N)
            for (int coins = 1; coins <= maxPts; coins++) { // TC: O(maxPts)
                /**
                 * Probability to score coins = 1 / maxPts
                 * Remaining Points = i - coins
                 * so, p[i] += probability of coins * probability of remaining
                 * i.e. p[i] += (1 / maxPts) * p[i - coins]
                 * i.e. p[i] += p[i - coins] / maxPts
                 * if (i - coins == 17 then game stops so (i - coins) < k)
                 */
                if (i - coins >= 0 && i - coins < k) {
                    p[i] += p[i - coins] / maxPts;
                }
            }
        }
        double probabilitySum = 0.0;
        for (int i = k; i <= n; i++) {
            probabilitySum += p[i];
        }
        return probabilitySum;
    }
}
