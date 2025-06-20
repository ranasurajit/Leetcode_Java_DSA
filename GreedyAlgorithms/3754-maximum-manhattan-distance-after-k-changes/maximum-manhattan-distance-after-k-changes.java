class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(4 x N) ~ O(N)
     * SC: O(1)
     */
    public int maxDistance(String s, int k) {
        int maxDist = 0;
        char[] horDirections = { 'E', 'W' }; // SC: O(2)
        char[] verDirections = { 'N', 'S' }; // SC: O(2)
        for (char hor : horDirections) { // TC: O(2)
            for (char ver : verDirections) { // TC: O(2)
                int effX = 0;
                int effY = 0;
                int remainingK = k;
                for (int i = 0; i < s.length(); i++) { // TC: O(N)
                    char ch = s.charAt(i);
                    if (ch == hor && remainingK > 0) {
                        ch = (ch == 'W') ? 'E' : 'W';
                        remainingK--;
                    }
                    if (ch == ver && remainingK > 0) {
                        ch = (ch == 'S') ? 'N' : 'S';
                        remainingK--;
                    }
                    if (ch == 'N') {
                        effY++;
                    }
                    if (ch == 'S') {
                        effY--;
                    }
                    if (ch == 'E') {
                        effX++;
                    }
                    if (ch == 'W') {
                        effX--;
                    }
                    int currentDist = Math.abs(effX) + Math.abs(effY);
                    maxDist = Math.max(maxDist, currentDist);
                }
            }
        }
        return maxDist;
    }
}
