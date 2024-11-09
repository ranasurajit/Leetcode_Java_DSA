class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public long minEnd(int n, int x) {
        // for AND operation of all elements = x, x has to be the minimum of nums
        long lastNum = (long) x;
        int count = 0;
        // as we already have x as the first element so we need to find n - 2 more elements
        while (count < n - 1) {          // TC : O(N)
            lastNum = (x | (lastNum + 1));
            count++;
        }
        return lastNum;
    }
}
