class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            mergeSortedList(nums, low, mid, high);
        }
    }

    private void mergeSortedList(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] sorted = new int[nums.length];
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                sorted[k] = nums[i];
                i++;
            } else {
                sorted[k] = nums[j];
                j++;
            }
            k++;
        }
        if (j > high) {
            while (i <= mid) {
                sorted[k++] = nums[i++];
            }
        }
        if (i > mid) {
            while (j <= high) {
                sorted[k++] = nums[j++];
            }
        }
        for (int p = low; p <= high; p++) {
            nums[p] = sorted[p];
        }
    }
}
