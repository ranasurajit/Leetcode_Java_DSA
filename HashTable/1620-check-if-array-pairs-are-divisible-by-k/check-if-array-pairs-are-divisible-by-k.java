class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        // intuition is sum of remainder pairs from above should sum up to k
        int[] map = new int[k];
        for (int i = 0; i < n; i++) {
            // handling negative numbers
            int rem = (arr[i] % k + k) % k; // store all the remainders in place
            map[rem]++;
        }
        /*
         * we need to check for remainders till k / 2 as remainders will range from 0 to k - 1
         * so if we check from 0 to k/2 then other half will be checked automatically 
         */
        if (map[0] % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (map[i] != map[k - i]) {
                return false;
            }
        }
        return true;
    }
}
