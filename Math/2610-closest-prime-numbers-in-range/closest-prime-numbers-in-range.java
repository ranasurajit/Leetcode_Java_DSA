class Solution {
    /**
     * Using Sieve of Eratosthenes and Two Pointers Approach
     *
     * TC: (R + R x log(log(R)) + R - L) ~ O(2 x R - L + R x log(log(R)))
     * SC: O(R)
     */
    public int[] closestPrimes(int left, int right) {
        int[] primes = new int[right + 1];  // SC: O(R)
        Arrays.fill(primes, 1);
        // as 0 and 1 are non-primes
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i * i <= right; i++) { // TC: O(R)
            if (primes[i] == 1) {
                for (int j = i * i; j <= right; j += i) { // TC: O(log(log(R)))
                    primes[j] = 0; // marking the multiples of prime numbers zero
                }
            }
        }
        /**
         * at the end of this we have a pre-computed 
         * data of all prime numbers till right
         */
        int[] result = { -1, -1 };
        int i = left;
        int j = left;
        int minDiff = Integer.MAX_VALUE;
        // Using Two Pointers
        while (i <= right && j <= right) {
            while (i <= right && primes[i] != 1) {
                i++;
            }
            j = i + 1;
            while (j <= right && primes[j] != 1) {
                j++;
            }
            int diff = j - i;
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = i;
                result[1] = j;
            }
            i++;
            j++;
        }
        return result[0] < left || result[1] > right ? new int[] { -1, -1 } : result;
    }
}
