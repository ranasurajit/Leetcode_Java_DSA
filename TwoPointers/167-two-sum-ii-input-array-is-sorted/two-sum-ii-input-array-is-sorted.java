class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int p = 0;
        int q = n - 1;
        while (p < q) { // TC: O(N)
            int sum = numbers[p] + numbers[q];
            if (sum == target) {
                return new int[] { p + 1, q + 1 };
            } else if (sum < target) {
                p++;
            } else {
                q--;
            }
        }
        return new int[] { -1, -1 };
    }
}
