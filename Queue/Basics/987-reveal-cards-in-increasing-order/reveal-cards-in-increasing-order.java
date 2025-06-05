class Solution {
    /**
     * Approach : Using Two Pointers and Sorting Approach
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int[] deckRevealedIncreasing(int[] deck) {
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
