class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        // doubling the colors array to form like a circular tile system
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
                System.out.println("## " + changes);
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
}
