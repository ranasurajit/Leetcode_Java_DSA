class Solution {
    /**
     * TC: O(N)
     * SC: O(M)
     * where N is total numbers in range (1 to n), M = banned.length
     */
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(M)
        for (int item : banned) {
            hs.add(item);
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {                // TC: O(N)
            if (hs.contains(i)) {
                continue;
            }
            if (sum + i <= maxSum) {
                sum += i;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
