class Solution {
    public int findJudge(int n, int[][] trust) {
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < trust.length; i++) {
            adj[trust[i][1]].add(trust[i][0]);
        }
        System.out.println(Arrays.toString(adj));
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (adj[i].size() == n - 1) {
                judge = i;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (adj[i].contains(judge)) {
                return -1;
            }
        }
        return judge;
    }
}
