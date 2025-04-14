class Solution {
    /**
     * Approach III : Optimal Enumeration Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1001) ~ O(1)
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        // Prefix frequency array to compute sum[i] = number of elements <= i before current j
        int[] sum = new int[1001]; // as 0 <= arr[i] <= 1000
        /**
         * To satisfy |arr[i] - arr[j]| <= a and |arr[i] - arr[k]| <= c 
         * arr[i] should be range of [arr[j] - a, arr[j] + a] and
         * arr[i] should be range of [arr[k] - c, arr[k] + c]
         * as 0 <= arr[i] <= 1000 (non-negatives)
         */
        for (int j = 0; j < n - 1; j++) { // TC: O(N)
            for (int k = j + 1; k < n; k++) { // TC: O(N)
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    // Define intersection range [low, high] for valid arr[i]
                    int lowj = arr[j] - a;
                    int highj = arr[j] + a;
                    int lowk = arr[k] - c;
                    int highk = arr[k] + c;
                    int low = Math.max(0, Math.max(lowj, lowk));
                    int high = Math.min(1000, Math.min(highj, highk));
                    if (low <= high) {
                        /**
                         * Use prefix sum to count how many i < j 
                         * satisfy arr[i] is in range [low, high]
                         */
                        if (low == 0) {
                            count += sum[high];
                        } else {
                            count += sum[high] - sum[low - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) { // TC: O(1000)
                ++sum[k];
            }
        }
        return count;
    }

    /**
     * Approach II : Better Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int countGoodTripletsApproachII(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) { // TC: O(N)
                        int y = Math.abs(arr[j] - arr[k]);
                        int z = Math.abs(arr[i] - arr[k]);
                        if (y <= b && z <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int countGoodTripletsApproachI(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    int x = Math.abs(arr[i] - arr[j]);
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[i] - arr[k]);
                    if (x <= a && y <= b && z <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
