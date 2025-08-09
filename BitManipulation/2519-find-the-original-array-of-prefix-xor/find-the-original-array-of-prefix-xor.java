class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        arr[0] = pref[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            arr[i] = pref[i] ^ pref[i - 1];
        }
        return arr;
    }
}
