class Solution {
    /**
     * Approach : Using Sieve Of Eratosthenes Approach
     * 
     * TC: O(N x log(log(N))) + O(N) ~ O(N x log(log(N)))
     * SC: O(N)
     */
    public int countPrimes(int n) {
        int[] primes = new int[n + 1]; // SC: O(N)
        Arrays.fill(primes, 1);
        primes[0] = 0;
        if (n > 1) {
            primes[1] = 0;
        }
        for (int i = 2; i * i <= n; i++) { // TC: O(N x log(log(N)))
            for (int j = i * i; j <= n; j += i) {
                primes[j] = 0;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (primes[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
