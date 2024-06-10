class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sortedHeights = new int[n];
        for (int i = 0; i < n; i++) {
            sortedHeights[i] = heights[i];
        }
        mergeSort(sortedHeights, 0, n - 1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != sortedHeights[i]) {
                count++;
            }
        }
        return count;
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeSortedArray(arr, start, mid, end);
        }
    }

    private void mergeSortedArray(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;
        int[] sorted = new int[arr.length];
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            } else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }
        if (j > end) {
            while (i <= mid) {
                sorted[k++] = arr[i++];
            }
        } else {
            while (j <= end) {
                sorted[k++] = arr[j++];
            }
        }
        for (int p = start; p <= end; p++) {
            arr[p] = sorted[p];
        }
    }
}
