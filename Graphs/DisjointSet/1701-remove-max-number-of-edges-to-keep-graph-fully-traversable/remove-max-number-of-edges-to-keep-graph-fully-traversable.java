class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (v1, v2) -> v2[0] - v1[0]);
        DSU aliceDSU = new DSU(n);
        DSU bobDSU = new DSU(n);
        int addedEdges = 0;
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            if (type == 1) {
                if (aliceDSU.find(u) != aliceDSU.find(v)) {
                    aliceDSU.union(u, v);
                    addedEdges++;
                }
            } else if (type == 2) {
                if (bobDSU.find(u) != bobDSU.find(v)) {
                    bobDSU.union(u, v);
                    addedEdges++;
                }
            } else {
                boolean add = false;
                if (aliceDSU.find(u) != aliceDSU.find(v)) {
                    aliceDSU.union(u, v);
                    add = true;
                }
                if (bobDSU.find(u) != bobDSU.find(v)) {
                    bobDSU.union(u, v);
                    add = true;
                }
                if (add) {
                    addedEdges++;
                }
            }
        }
        if (aliceDSU.isSingle() && bobDSU.isSingle()) {
            return edges.length - addedEdges;
        }
        return -1;
    }

    class DSU {
        private int[] parent;
        private int[] rank;
        private int components;

        public DSU (int n) {
            this.parent = new int[n + 1];
            this.rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                this.parent[i] = i;
            }
            this.components = n;
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            if (rank[parentY] > rank[parentX]) {
                parent[parentX] = parentY;
            } else if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else {
                parent[parentX] = parentY;
                rank[parentY]++;
            }
            components--;
        }

        public boolean isSingle() {
            return components == 1;
        }
    }
}
