class Solution {
    /**
     * TC: O((log(N) base 10) x (log(N) base 10))
     * SC: O(log(N) base 10)
     */
    public int findKthNumber(int n, int k) {
        int current = 1;
        // considering 1 so negating -1 for k
        k -= 1;
        while (k > 0) {
            int count = countNumbers(current, current + 1, n);
            if (count <= k) {
                // skipping the current tree and going to the next tree
                current += 1;
                k -= count;
            } else {
                // going to current tree in depth
                current *= 10;
                k -= 1;
            }
        }
        return current;
    }

    private int countNumbers(long current, long next, int n) {
        int count = 0;
        while (current <= n) {
            count += Math.min(next, (long) (n + 1)) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }
}
