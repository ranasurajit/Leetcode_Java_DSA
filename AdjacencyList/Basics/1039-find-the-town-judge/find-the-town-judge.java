class Solution {
    public int findJudge(int n, int[][] trust) {
        // Calculate the people directing to judge by forming indegrees array
        int[] indegrees = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            indegrees[trust[i][1]]++;
        }
        int judge = -1;
        // if a person is judge then number of indegrees would be number of people (n) - 1
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == n - 1) {
                judge = i;
                break;
            }
        }
        // checking if the judge is someone who also trusts someone then return -1
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][0] == judge) {
                return -1;
            }
        }
        return judge;
    }
}
