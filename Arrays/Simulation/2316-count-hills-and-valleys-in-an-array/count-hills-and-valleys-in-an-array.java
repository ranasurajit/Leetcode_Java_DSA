class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int countHillValley(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>(); // SC: O(N)
        list.add(nums[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (list.get(list.size() - 1) != nums[i]) {
                list.add(nums[i]);
            }
        }
        int m = list.size();
        int hills = 0;
        int valleys = 0;
        for (int i = 1; i < m - 1; i++) { // TC: O(N)
            int current = list.get(i);
            int prev = list.get(i - 1);
            int next = list.get(i + 1);
            if (current > prev && current > next) {
                hills++;
            }
            if (current < prev && current < next) {
                valleys++;
            }
        }
        return hills + valleys;
    }
}
