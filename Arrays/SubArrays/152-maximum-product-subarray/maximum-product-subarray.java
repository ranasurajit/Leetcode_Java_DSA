class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        double prefix = 1;
        double suffix = 1;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = (double) (prefix * nums[i]);
            suffix = (double) (suffix * nums[n - i - 1]);
            System.out.println(prefix + " -> " + suffix);
            max = (double) Math.max(max, Math.max(prefix, suffix));
        }
        return (int) max;
    }
}
