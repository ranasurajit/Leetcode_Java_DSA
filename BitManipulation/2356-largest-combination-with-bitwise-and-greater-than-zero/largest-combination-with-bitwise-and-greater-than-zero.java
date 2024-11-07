class Solution {
    /**
     * TC: O(32 x N) ~ O(N)
     * SC: O(1)
     */
    public int largestCombination(int[] candidates) {
        int countMax = 0;
        for (int i = 0; i < 32; i++) {
            int countIthBit = 0;
            for (int it : candidates) { // TC: O(N)
                countIthBit += (it & (1 << i)) != 0 ? 1 : 0;
            }
            countMax = Math.max(countMax, countIthBit);
        }
        return countMax;
    }
}
