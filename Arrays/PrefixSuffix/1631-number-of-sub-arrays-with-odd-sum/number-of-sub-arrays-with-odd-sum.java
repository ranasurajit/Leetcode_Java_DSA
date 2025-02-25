class Solution {
    /** 
     * Better Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int MOD = (int) 1e9 + 7;
        int[] prefix = new int[n];    // SC: O(N)
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) { // TC: O(N)
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int even = 1; // initially prefixSum is 0 so even count = 1
        int odd = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (prefix[i] % 2 == 0) {
                // odd + even = odd
                count = (count + odd) % MOD;
                even++;
            } else {
                // even + odd = odd
                count = (count + even) % MOD;
                odd++;
            }
        }
        return count;
    }

    /** 
     * Better Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int numOfSubarraysApproachII(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /** 
     * Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int numOfSubarraysApproachIII(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
