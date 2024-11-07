class Solution {
    /**
     * TC: O(32 x N) ~ O(N)
     * SC: O(32) ~ O(1)
     */
    public int largestCombination(int[] candidates) {
        int countMax = 0;
        int n = candidates.length;
        // for 32 bits we need this placeholder - SC: O(32)
        int[] bitData = new int[32];
        for (int i = 0; i < 32; i++) { // TC: O(32)
            int countIthBit = 0;
            for (int it : candidates) { // TC: O(N)
                if ((it & (1 << i)) != 0) {
                    bitData[i]++;
                }
            }
            countMax = Math.max(countMax, bitData[i]);
        }
        return countMax;
    }
}
