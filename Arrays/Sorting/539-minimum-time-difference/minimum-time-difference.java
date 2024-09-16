class Solution {
    /**
     * TC: O(Nlog(N)) + O(2N) ~ O(Nlog(N))
     * SC: O(N)
     */
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int currentDiff = 0;
        List<Integer> minutes = new ArrayList<Integer>(); // SC: O(N)
        for (String s : timePoints) { // TC: O(N)
            minutes.add(Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5)));
        }
        Collections.sort(minutes); // TC: O(Nlog(N))
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) { // TC: O(N)
            min = Math.min(min, minutes.get(i) - minutes.get(i - 1));
        }
        // calculating offsets for hours around 00:00 i.e. 24:00
        int endOffset = 24 * 60 - minutes.get(n - 1);
        int startOffset = minutes.get(0);
        return Math.min(min, endOffset + startOffset);
    }
}
