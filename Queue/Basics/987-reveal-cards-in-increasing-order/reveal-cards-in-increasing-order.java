class Solution {
    /**
     * Approach II : Using Two Pointers, Queues and Sorting Approach
     *
     * TC: O(N x log(N) + 2 x N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck); // TC: O(N x log(N))
        // we will be storing indices in the Queue
        Queue<Integer> queue = new LinkedList<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            queue.offer(i);
        }
        int i = 0; // pointer at array 'deck'
        while (i < n) { // TC: O(N)
            int idx = queue.poll();
            result[idx] = deck[i];
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
            i++;
        }
        return result;
    }

    /**
     * Approach I : Using Two Pointers and Sorting Approach
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int[] deckRevealedIncreasingTwoPointers(int[] deck) {
        int n = deck.length;
        int[] result = new int[n];
        Arrays.sort(deck); // TC: O(N x log(N))
        int i = 0; // pointer at array 'deck'
        int j = 0; // pointer at array 'result'
        boolean skip = false;
        while (i < n) { // TC: O(N x log(N))
            if (result[j] == 0) {
                // we can insert into result[index] provided skip = false
                if (!skip) {
                    result[j] = deck[i];
                    i++;
                }
                skip = !skip;
            }
            j = (j + 1) % n;
        }
        return result;
    }
}
