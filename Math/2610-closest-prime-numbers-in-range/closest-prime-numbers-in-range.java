class Solution {
    /**
     * Using Sieve of Eratosthenes Approach
     *
     * TC: (R + R x log(log(R)) + R - L) ~ O(2 x R - L + R x log(log(R)))
     * SC: O(R)
     */
    public int[] closestPrimes(int left, int right) {
        // Sieve of Eratosthenes
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
         * Count number of prime numbers in the range [left, right]
         */
        List<Integer> primeNumbers = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (primes[i] == 1) {
                primeNumbers.add(i);
            }
        }
        // default return if we have no pair
        if (primeNumbers.size() < 2) {
            return new int[] { -1, -1 };
        }
        // from here it is guaranted that we have atleast two prime numbers
        int minDiff = right - left + 1;
        int first = -1;
        int second = -1;
        for (int i = 1; i < primeNumbers.size(); i++) { // TC: O(K)
            int currentDiff = primeNumbers.get(i) - primeNumbers.get(i - 1);
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                first = primeNumbers.get(i - 1);
                second = primeNumbers.get(i);
            }
        }
        return new int[] { first, second };
    }
}
