class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> uniques = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            storeNumAndReverse(nums[i], uniques);
        }
        return uniques.size();
    }

    private void storeNumAndReverse(int num, Set<Integer> hs) {
        hs.add(num);
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = 10 * rev + rem;
            num = num / 10;
        }
        hs.add(rev);
    }
}
