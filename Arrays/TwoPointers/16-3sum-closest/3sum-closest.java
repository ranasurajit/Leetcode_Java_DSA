class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int closest = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int p = i + 1;
            int q = n - 1;
            while (p < q) {
                int sum = nums[i] + nums[p] + nums[q];
                int d = Math.abs(sum - target);
                if (d < diff) {
                    // keep decreasing the distance of target and sum
                    diff = d;
                    closest = sum;
                }
                if (d == diff) {
                    /*
                     * if distance b/w two numbers from target is 
                     * same closest will be largest
                     */ 
                    closest = Math.max(closest, sum);
                }
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    p++;
                } else {
                    q--;
                }
            }
        }
        return closest;
    }
}
