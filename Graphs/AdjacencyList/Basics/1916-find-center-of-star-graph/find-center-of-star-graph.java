class Solution {
    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }

    // public int findCenter(int[][] edges) {
    //     Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
    //     for (int i = 0;i < edges.length; i++) {
    //         if (!hm.containsKey(edges[i][0])) {
    //             hm.put(edges[i][0], new ArrayList<Integer>());
    //         }
    //         if (!hm.containsKey(edges[i][1])) {
    //             hm.put(edges[i][1], new ArrayList<Integer>());
    //         }
    //         hm.get(edges[i][0]).add(edges[i][1]);
    //         hm.get(edges[i][1]).add(edges[i][0]);
    //     }
    //     for (Integer it : hm.keySet()) {
    //         if (hm.get(it).size() == hm.size() - 1) {
    //             return it;
    //         }
    //     }
    //     return 0;
    // }
}
