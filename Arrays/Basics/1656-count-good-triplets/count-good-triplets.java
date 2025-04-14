class Solution {
    /**
     * Approach II : Better Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) { // TC: O(N)
                        int y = Math.abs(arr[j] - arr[k]);
                        int z = Math.abs(arr[i] - arr[k]);
                        if (y <= b && z <= c) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int countGoodTripletsApproachI(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    int x = Math.abs(arr[i] - arr[j]);
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[i] - arr[k]);
                    if (x <= a && y <= b && z <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
