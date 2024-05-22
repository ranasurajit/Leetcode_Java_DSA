class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hs.add(nums[i]);
            hs.add(reverse(nums[i]));
        }
        return hs.size();
    }

    private int reverse(int num) {
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = 10 * rev + rem;
            num = num / 10;
        }
        return rev;
    }
}
