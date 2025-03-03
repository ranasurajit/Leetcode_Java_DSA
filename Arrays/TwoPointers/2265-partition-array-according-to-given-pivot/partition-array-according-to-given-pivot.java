class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int lCount = 0;
        int gCount = 0;
        int pCount = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] < pivot) {
                lCount++;
            } else if (nums[i] == pivot) {
                pCount++;
            } else {
                gCount++;
            }
        }
        int lPointer = 0;
        int gPointer = n - gCount;
        int pPointer = n - pCount - gCount;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums[i] < pivot) {
                result[lPointer++] = nums[i];
            } else if (nums[i] == pivot) {
                result[pPointer++] = nums[i];
            } else {
                result[gPointer++] = nums[i];
            }
        }
        return result;
    }

    /**
     * Approach I : Using Extra Space
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int[] pivotArrayApproachI(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> lessList = new ArrayList<Integer>();
        List<Integer> pivotList = new ArrayList<Integer>();
        List<Integer> greaList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
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
        while (index < n) { // TC: O(N)
            result[index] = lessList.get(index++);
        }
        return result;
    }
}
