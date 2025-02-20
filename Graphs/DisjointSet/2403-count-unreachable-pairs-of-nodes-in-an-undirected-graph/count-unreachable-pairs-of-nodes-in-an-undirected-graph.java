class Solution {
    /**
     * Using DSU Approach
     *
     * TC: O(4 x V + E) ~ O(V + E)
     * SC: O(4 x V) ~ O(V)
     * 
     * @param n
     * @param edges
     * @return
     */
    public long countPairs(int n, int[][] edges) {
        int[] rank = new int[n];      // SC: O(V)
        Arrays.fill(rank, 1);

        int[] parent = new int[n];    // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            parent[i] = i;
        }

        for (int[] edge : edges) {    // TC: O(E)
            // create edges and update parent
            union(parent, rank, edge[0], edge[1]); // TC: O(V), SC: O(V)
        }

        // creating a map to count the number of nodes in each union sets
        Map<Long, Long> map = new HashMap<Long, Long>(); // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            long key = find(parent, i);
            map.put(key, (long) map.getOrDefault(key, 0L) + 1);
        }
        // calculating pairs of unreachable nodes
        long remainingNodes = n;
        long pairs = 0L;
        for (Long key : map.keySet()) { // TC: O(V)
            long size = map.get(key);
            pairs += size * (remainingNodes - size);
            remainingNodes -= size;
        }
        return pairs;
    }

    /**
     * DSU - Find Path by Compression Approach
     * 
     * TC: O(V)
     * SC: O(V)
     * 
     * @param parent
     * @param x
     * @return
     */
    private int find(int[] parent, int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent, parent[x]);
    }

    /**
     * DSU - Union By Rank Approach
     *
     * TC: O(V)
     * SC: O(V)
     * 
     * @param parent
     * @param rank
     * @param x
     * @param y
     */
    private void union(int[] parent, int[] rank, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);
        if (xParent == yParent) {
            // as both nodes have same parent so do nothing
            return;
        }
        if (rank[xParent] > rank[yParent]) {
            // make x as parent of y
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            // make y as parent of x
            parent[xParent] = yParent;
        } else {
            // make anyone as parent and increase it's rank
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
}
