class Solution {
    /**
     * Approach I : Using Shifting Approach 
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
