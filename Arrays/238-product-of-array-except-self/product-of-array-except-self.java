class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            prefix = i == 0 ? 1 : prefix * nums[i - 1];
            product[i] = prefix;
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            suffix = i == n - 1 ? 1 : suffix * nums[i + 1];
            product[i] = product[i] * suffix;
        }
        return product;
    }
}
