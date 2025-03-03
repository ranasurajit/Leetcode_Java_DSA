class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> lessList = new ArrayList<Integer>();
        List<Integer> pivotList = new ArrayList<Integer>();
        List<Integer> greaList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                lessList.add(nums[i]);
            } else if (nums[i] == pivot) {
                pivotList.add(nums[i]);
            } else {
                greaList.add(nums[i]);
            }
        }
        lessList.addAll(pivotList);
        lessList.addAll(greaList);
        int[] result = new int[n];
        int index = 0;
        while (index < n) {
            result[index] = lessList.get(index++);
        }
        return result;
    }
}
