class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            mergeSortedArrays(nums, start, mid, end);
        }
    }

    private void mergeSortedArrays(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        int[] sorted = new int[nums.length];
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                sorted[k] = nums[i];
                i++;
            } else {
                sorted[k] = nums[j];
                j++;
            }
            k++;
        }
        if (j > end) {
            while (i <= mid) {
                sorted[k++] = nums[i++];
            }
        }
        if (i > mid) {
            while (j <= end) {
                sorted[k++] = nums[j++];
            }
        }
        for (int p = start; p <= end; p++) {
            nums[p] = sorted[p];
        }
    }
}
