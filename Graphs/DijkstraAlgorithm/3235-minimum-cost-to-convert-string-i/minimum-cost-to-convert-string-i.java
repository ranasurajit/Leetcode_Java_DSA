class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        HashSet<Character> vertices = new HashSet<Character>();
        for (char ch : original) {
            vertices.add(ch);
        }
        for (char ch : changed) {
            vertices.add(ch);
        }
        HashMap<Character, ArrayList<Pair>> adj = createGraph(vertices, original, changed, cost);
        int[][] matrix = new int[26][26];
        for (int[] row : matrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < original.length; i++) {
            dijkstraShortestPath(adj, original[i], matrix);
        }
        long minCost = 0L;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            } 
            if (matrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE) {
                return -1L;
            } else {
                minCost += (long) matrix[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            }
        }
        return minCost;
    }

    private void dijkstraShortestPath(HashMap<Character, ArrayList<Pair>> adj, 
        char source, int[][] matrix) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.dist - q.dist);
        pq.offer(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int dist = current.dist;
            char u = current.node;
            for (int i = 0; i < adj.getOrDefault(u, new ArrayList<Pair>()).size(); i++) {
                int edgeWeight = adj.get(u).get(i).dist;
                char v = adj.get(u).get(i).node;
                if (dist + edgeWeight < matrix[source - 'a'][v - 'a']) {
                    matrix[source - 'a'][v - 'a'] = dist + edgeWeight;
                    pq.offer(new Pair(v, dist + edgeWeight));
                }
            }
        }
    }

    private HashMap<Character, ArrayList<Pair>> createGraph(HashSet<Character> vertices,
        char[] original, char[] changed, int[] cost) {
        HashMap<Character, ArrayList<Pair>> adj = new HashMap<Character, ArrayList<Pair>>();
        for (Character ch : vertices) {
            adj.put(ch, new ArrayList<Pair>());
        }
        for (int i = 0; i < original.length; i++) {
            adj.get(original[i]).add(new Pair(changed[i], cost[i]));
        }
        return adj;
    }

    class Pair {
        char node;
        int dist;
        public Pair (char node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
