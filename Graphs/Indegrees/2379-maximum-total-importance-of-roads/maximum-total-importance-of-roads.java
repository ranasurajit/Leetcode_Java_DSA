class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indegrees = new int[n];
        long maxImportance = 0L;
        for (int i = 0; i < roads.length; i++) {
            indegrees[roads[i][0]]++;
            indegrees[roads[i][1]]++; 
        }
        Arrays.sort(indegrees);
        for (int i = 1; i <= n; i++) {
            maxImportance += (long) i * indegrees[i - 1];
        }
        return maxImportance;
    }
}
