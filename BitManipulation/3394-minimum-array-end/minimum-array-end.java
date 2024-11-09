class Solution {
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public long minEnd(int n, int x) {
        // for AND operation of all elements = x, x has to be the minimum of nums
        long num = x;
        for (int i = 1; i < n; i++) {
            num = (x | (num + 1));
        }
        return num;
    }
}
