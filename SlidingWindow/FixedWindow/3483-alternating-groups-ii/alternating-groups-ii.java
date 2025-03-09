class Solution {
    /**
     * Approach II : Using Sliding Window (Fixed Size) Approach
     *
     * TC: O(N + K - 1) ~ O(N + K)
     * SC: O(N + 2 x K - 1) ~ O(N + K)
     */
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        // imitating the 'colors' array to form like a circular tile system
        int[] circularColors = new int[n + k - 1]; // SC: O(N + K - 1)
        for (int i = 0; i < n + k - 1; i++) {      // TC: O(N + K - 1)
            circularColors[i] = colors[i % n];
        }
        int groups = 0;
        int changes = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(); // SC: O(K)
        int i = 0; // start pointer of the sliding window
        int j = 0; // end pointer of the sliding window
        while (j < n + k - 1) { // TC: O(N + K - 1)
            if (!deque.isEmpty() && circularColors[j] != deque.peekLast()) {
                changes++;
            }
            deque.addLast(circularColors[j]);
            if (j - i + 1 < k) {
                // sliding window size is not yet met
                j++;
            } else if (j - i + 1 == k) {
                if (changes == k - 1) {
                    groups++;
                }
                // remove calculation before moving to next sliding window
                int prev = -1;
                if (!deque.isEmpty()) {
                    prev = deque.pollFirst();
                }
                // now slide to next window maintaining its size k
                if (prev != deque.peekFirst()) {
                    changes--;
                }
                i++;
                j++;
            }
        }
        return groups;
    }

    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(K x N + N + K - 1) ~ O(K x N)
     * SC: O(N + K - 1)
     */
    public int numberOfAlternatingGroupsApproachI(int[] colors, int k) {
        int n = colors.length;
        // imitating the 'colors' array to form like a circular tile system
        int[] circularColors = new int[n + k - 1]; // SC: O(N + K - 1)
        for (int i = 0; i < n + k - 1; i++) {      // TC: O(N + K - 1)
            circularColors[i] = colors[i % n];
        }
        int groups = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int changes = 0;
            for (int j = i + 1; j < i + k; j++) { // TC: O(K)
                if (circularColors[j] != circularColors[j - 1]) {
                    changes++;
                }
            }
            if (changes == k - 1) {
                /**
                 * number of changes = k guarantees
                 * that our sliding window has alternative colors
                 */
                groups++;
            }
        }
        return groups;
    }
}
