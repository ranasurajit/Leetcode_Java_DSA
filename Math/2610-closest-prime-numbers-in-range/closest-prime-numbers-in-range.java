class Solution {
    /**
     * Approach II : Using Sieve of Eratosthenes Approach
     *
     * TC: (R + R x log(log(R)) + R - L + K) ~ O(2 x R - L + K + R x log(log(R)))
     * SC: O(R + K)
     * where K = number of prime numbers between left and right
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
        List<Integer> primeNumbers = new ArrayList<Integer>(); // SC: O(K)
        for (int i = left; i <= right; i++) { // TC: O(R - L)
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

    /**
     * Approach I : Using Sieve of Eratosthenes and Two Pointers Approach
     *
     * TC: (2 x R + R x log(log(R))) ~ O(R + R x log(log(R)))
     * SC: O(R)
     */
    public int[] closestPrimesApproachI(int left, int right) {
        int[] primes = new int[right + 1];     // SC: O(R)
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
        while (i <= right && j <= right) { // TC: O(R)
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
