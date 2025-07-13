class Solution {
    /**
     * Approach : Using Greedy (Sorting + Two Pointers) Approach
     *
     * TC: O(M x log(M) + N x log(N) + Min(M, N))
     * SC: O(1)
     */
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int m = players.length;
        int n = trainers.length;
        Arrays.sort(players);  // TC: O(M x log(M))
        Arrays.sort(trainers); // TC: O(N x log(N))
        int p = m - 1; // pointer at the end of array 'players'
        int t = n - 1; // pointer at the end of array 'trainers'
        int count = 0;
        while (p >= 0 && t >= 0) { // TC: O(Min(M, N))
            if (trainers[t] >= players[p]) {
                t--;
                count++;
            }
            p--;
        }
        return count;
    }
}
