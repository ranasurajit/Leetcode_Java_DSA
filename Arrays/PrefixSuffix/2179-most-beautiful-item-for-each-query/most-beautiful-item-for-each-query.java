class Solution {
    /**
     * TC: O(N x log(N) + Q x log(N))
     * SC: O(1)
     */
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = items.length;
        int q = queries.length;
        int[] answer = new int[q];                         // SC: O(Q)
        // sorting the items based on the price            // TC: O(N x log(N))
        Arrays.sort(items, (int[] a, int[] b) -> Integer.compare(a[0], b[0]));
        int maxBeautySeen = items[0][1];
        for (int i = 1; i < n; i++) {                      // TC: O(N)
            maxBeautySeen = Math.max(maxBeautySeen, items[i][1]);
            // pre-process items array to store the maximum beauty seen till any index
            items[i][1] = maxBeautySeen;
        }
        for (int i = 0; i < q; i++) {                     // TC: O(Q)
            int query = queries[i];
            answer[i] = customBinarySearch(query, items); // TC: O(log(N))
        }
        return answer;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    private int customBinarySearch(int query, int[][] items) {
        int maxBeauty = 0;
        int low = 0;
        int high = items.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (items[mid][0] <= query) {
                maxBeauty = Math.max(maxBeauty, items[mid][1]);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxBeauty;
    }
}
