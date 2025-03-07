class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n + 1];
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == primes[j] * dp[pointers[j]]) {
                    pointers[j]++;
                }
            }
        }
        return (int) dp[n];
    }
}
