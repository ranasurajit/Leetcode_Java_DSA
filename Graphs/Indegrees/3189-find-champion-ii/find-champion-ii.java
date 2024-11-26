class Solution {
    /**
     * TC: O(V + E)
     * SC: O(V)
     */
    public int findChampion(int n, int[][] edges) {
        // indegree of any node having 0 is the winner
        int[] indegrees = new int[n]; // SC: O(V)
        for (int[] edge : edges) {    // TC: O(E)
            indegrees[edge[1]]++;
        }
        int champion = -1;
        int countChampion = 0;
        for (int i = 0; i < n; i++) { // TC: O(V)
            if (indegrees[i] == 0) {
                champion = i;
                countChampion++;
            }
        }
        // countChampion > 1 then there is no single champion (tie) so return -1
        return countChampion > 1 ? -1 : champion;
    }
}
