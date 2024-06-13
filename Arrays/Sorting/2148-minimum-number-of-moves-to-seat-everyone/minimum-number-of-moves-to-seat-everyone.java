class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        sortArray(seats);
        sortArray(students);
        int moves = 0;
        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    private void sortArray(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) / 2);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeSortedArrays(arr, start, mid, end);
        }
    }

    private void mergeSortedArrays(int[] arr, int start, int mid, int end) {
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
