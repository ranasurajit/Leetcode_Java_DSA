class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer, ArrayList<Pair>> adj = createGraph(n, edges);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = dijkstrasPath(adj, n, i);
        }
        return getCityWithSmallestNeighbours(matrix, n, distanceThreshold);
    }

    private int getCityWithSmallestNeighbours(int[][] matrix, int n, int threshold) {
        int resultCity = -1;
        int leastCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int maxReach = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] <= threshold) {
                    maxReach++;
                }
            }
            if (maxReach <= leastCount) {
                leastCount = maxReach;
                resultCity = i;
            }
        }
        return resultCity;
    }

    private int[] dijkstrasPath(HashMap<Integer, ArrayList<Pair>> adj, int n, int source) {
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[source] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.dist - q.dist);
        pq.offer(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int dist = current.dist;
            int u = current.node;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int edgeWeight = adj.get(u).get(i).dist;
                int edgeNode = adj.get(u).get(i).node;
                if (dist + edgeWeight < minDist[edgeNode]) {
                    minDist[edgeNode] = dist + edgeWeight;
                    pq.offer(new Pair(edgeNode, dist + edgeWeight));
                }
            }
        }
        return minDist;
    }

    private HashMap<Integer, ArrayList<Pair>> createGraph(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Pair>> adj = new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        return adj;
    }
}

class Pair {
    int node;
    int dist;
    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
