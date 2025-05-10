class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        return countSubArraysWithLessThanEqualsKOddNumbers(nums, n, k) -
            countSubArraysWithLessThanEqualsKOddNumbers(nums, n, k - 1);
    }

    private int countSubArraysWithLessThanEqualsKOddNumbers(int[] nums, int n, int k) {
        if (k < 0) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int countOdd = 0;
        int niceSubArrayCount = 0;
        while (j < n) { // TC: O(N)
            if ((nums[j] & 1) != 0) {
                // odd number at nums[j] found
                countOdd++;
            }
            while (countOdd > k) {
                // remove computation from index 'i'
                if ((nums[i] & 1) != 0) {
                    // odd number at nums[i] found
                    countOdd--;
                }
                i++;
            }
            niceSubArrayCount += (j - i + 1);
            j++;
        }
        return niceSubArrayCount;
    }
}
