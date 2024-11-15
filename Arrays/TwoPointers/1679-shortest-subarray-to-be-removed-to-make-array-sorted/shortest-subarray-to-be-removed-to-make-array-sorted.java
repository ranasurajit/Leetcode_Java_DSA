class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int j = n - 1;
        while (j > 0 && arr[j] >= arr[j - 1]) {
            j--;
        }
        if (j == 0) {
            // this means the array 'arr' was sorted already
            return 0;
        }
        int result = j; // atleast we found j to be at index after which all elements are sorted
        int i = 0;
        // finding the correct indices i and j such that array is sorted
        while (i < j && (i == 0 || arr[i] >= arr[i - 1])) {
            while (j < n && arr[i] > arr[j]) {
                j++;
            }
            result = Math.min(result, j - i - 1);
            i++;
        }
        return result;
    }
}
