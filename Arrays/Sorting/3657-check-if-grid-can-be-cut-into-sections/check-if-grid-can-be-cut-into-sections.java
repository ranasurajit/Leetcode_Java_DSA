class Solution {
    /**
     * Approach : Using Array Sorting
     *
     * TC: O(2 x (Q x log(Q) + Q)) ~ O(Q x log(Q))
     * SC: O(6 x Q) ~ O(Q)
     */
    public boolean checkValidCuts(int n, int[][] rectangles) {
        int q = rectangles.length;
        List<int[]> vList = new ArrayList<int[]>(); // SC: O(Q)
        List<int[]> hList = new ArrayList<int[]>(); // SC: O(Q)
        for (int[] rect : rectangles) { // TC: O(Q)
            hList.add(new int[] { rect[0], rect[2] });
            vList.add(new int[] { rect[1], rect[3] });
        }
        int[][] hArr = hList.toArray(new int[hList.size()][]); // SC: O(Q)
        int[][] vArr = vList.toArray(new int[vList.size()][]); // SC: O(Q)
        // Check for horizontal partitions
        List<int[]> mergedHArr = mergeIntervals(hArr); // TC: O(Q x log(Q)), SC: O(Q)
        if (mergedHArr.size() > 2) {
            return true;
        }
        // Check for vertical partitions
        List<int[]> mergedVArr = mergeIntervals(vArr); // TC: O(Q x log(Q)), SC: O(Q)
        if (mergedVArr.size() > 2) {
            return true;
        }
        return false;
    }

    /**
     * Merging Intervals Approach
     *
     * TC: O(Q x log(Q) + Q) ~ O(Q x log(Q))
     * SC: O(Q)
     */
    private List<int[]> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        }); // TC: O(Q x log(Q))
        List<int[]> merged = new ArrayList<int[]>(); // SC: O(Q)
        merged.add(intervals[0]);  
        for (int i = 1; i < intervals.length; i++) { // TC: O(Q)
            if (intervals[i][0] < merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = 
                    Math.max(merged.get(merged.size() - 1)[1],
                        intervals[i][1]);
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged;
    }
}
