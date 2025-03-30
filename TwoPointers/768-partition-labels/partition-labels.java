class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(26) ~ O(1)
     */
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> partitions = new ArrayList<Integer>();
        int[] lastOccur = new int[26]; // SC: O(26)
        for (int i = 0; i < n; i++) { // TC: O(N)
            lastOccur[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (end == -1) {
                end = lastOccur[s.charAt(i) - 'a'];
                int j = 0;
                for (j = start + 1; j <= end; j++) {
                    if (lastOccur[s.charAt(j) - 'a'] > end) {
                        end = lastOccur[s.charAt(j) - 'a'];
                    }
                }
                partitions.add(j - i);
                start = j;
                i = start - 1;
                end = -1;
            }
        }
        return partitions;
    }
}
