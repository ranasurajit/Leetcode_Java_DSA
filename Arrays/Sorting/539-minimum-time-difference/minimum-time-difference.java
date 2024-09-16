class Solution {
    /**
     * TC: O(Nlog(N)) + O(2N) ~ O(Nlog(N))
     * SC: O(N)
     */
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int currentDiff = 0;
        int[] minutes = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            String s = timePoints.get(i);
            minutes[i] = Integer.parseInt(s.substring(0, 2)) * 60 + 
                Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(minutes); // TC: O(Nlog(N))
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) { // TC: O(N)
            min = Math.min(min, minutes[i] - minutes[i - 1]);
        }
        // calculating offsets for hours around 00:00 i.e. 24:00
        int endOffset = 24 * 60 - minutes[n - 1];
        int startOffset = minutes[0];
        return Math.min(min, endOffset + startOffset);
    }
}
