class Solution {
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int longestSquareStreak(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int it : nums) { // TC: O(N)
            max = Math.max(max, it);
            hs.add(it);
        }
        int maxStreak = -1;
        for (int it : nums) { // TC: O(N)
            long current = (long) it;
            int streak = 0;
            while (hs.contains((int) current)) {
                streak++;
                if (current * current > max) {
                    break;
                }
                current = current * current;
            }
            maxStreak = Math.max(maxStreak, streak);
        }
        return maxStreak < 2 ? -1 : maxStreak;
    }
}
