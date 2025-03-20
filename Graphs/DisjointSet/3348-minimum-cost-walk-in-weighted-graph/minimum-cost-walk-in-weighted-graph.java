class Solution {
    /**
     * Using DSU Approach
     *
     * TC: O(V + E + Q x log(V))
     * SC: O(Q + 2 x V + 2 x Q x V) ~ O(Q x V)
     */
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int q = query.length;
        int[] result = new int[q]; // SC: O(Q)
        /**
         * Now we need to find if the vertices are connected/disconnected
         * Using DSU Approach
         */
        int[] parent = new int[n]; // SC: O(V)
        for (int i = 0; i < n; i++) { // TC: O(V)
            parent[i] = i;
        }
        int[] cost = new int[n]; // SC: O(V)
        Arrays.fill(cost, -1);
        /**
         * We would calculate the AND of all the edge weights and link it to parent node
         *
         * For any query, if vertices belong to same component (connected components)
         */
        for (int[] edge : edges) { // TC: O(E)
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int parentU = find(u, parent);
            int parentV = find(v, parent);
            if (parentU != parentV) {
                union(parentU, parentV, parent); // TC: O(1)
                cost[parentU] &= cost[parentV];
            }
            cost[parentU] &= w;
        }
        /**
         * Iterating over the queries to fill the minimum cost
         * The minimum cost will be total AND operation calculated
         * in cost else we will return -1
         */
        for (int i = 0; i < q; i++) { // TC: O(Q)
            int parentQ1 = find(query[i][0], parent); // TC: O(log(V)), SC: O(V)
            int parentQ2 = find(query[i][1], parent); // TC: O(log(V)), SC: O(V)
            if (query[i][0] == query[i][1]) {
                result[i] = 0;
            } else if (parentQ1 == parentQ2) {
                result[i] = cost[parentQ1];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    /**
     * TC: O(log(V))
     * SC: O(V)
     */
    private int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private void union(int x, int y, int[] parent) {
        parent[y] = x;
    }
}
