class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0;
        int maxSeen = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            maxSeen = Math.max(maxSeen, arr[i]);
            if (i == maxSeen) {
                chunks++;
            }
        }
        return chunks;
    }
}
