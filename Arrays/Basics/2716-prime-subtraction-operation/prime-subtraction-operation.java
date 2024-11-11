class Solution {
    /**
     * TC: O(N x Max(Nums))
     * SC: O(1000) ~ O(1)
     */
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        boolean[] primeNums = new boolean[1000];     // SC: O(1000)
        sieveOfEratosthenes(primeNums);
        // for loop from right to left
        for (int i = n - 2; i >= 0; i--) {           // TC: O(N)
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            for (int p = 2; p < nums[i]; p++) {      // TC: O(Max(Nums))
                if (!primeNums[p]) {
                    continue;
                }
                if (nums[i] - p < nums[i + 1]) {
                    nums[i] -= p;
                    break;
                }
            }
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private void sieveOfEratosthenes(boolean[] primeNums) {
        Arrays.fill(primeNums, true);
        primeNums[0] = false;
        primeNums[1] = false;
        for (int i = 2; i * i <= 1000; i++) {                 // TC: O(1000)
            if (primeNums[i]) {
                for (int j = i * i; j < 1000; j += i) {       // TC: O(1000)
                    primeNums[j] = false;
                }
            }
        }
    }
}
