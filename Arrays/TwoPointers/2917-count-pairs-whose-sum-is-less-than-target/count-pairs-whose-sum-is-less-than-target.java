class Solution {
    /**
     * TC: O(N + Nlog(N)) ~ O(Nlog(N))
     * SC: O(1)
     */
    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        Collections.sort(nums); // TC: O(Nlog(N))
        int count = 0;
        // TC: O(N) as i and j travels total n elements in opposite direction - ammortized TC
        for (int i = 0, j = n - 1; i < n; i++) {
            int sum = nums.get(i) + nums.get(j);
            while (i != j && sum >= target) {
                // we need to decrease the sum
                j--;
                sum = nums.get(i) + nums.get(j);
            }
            if (i == j) {
                break;
            }
            count += (j - i); // counting all valid pairs here
        }
        return count;
    }
}
