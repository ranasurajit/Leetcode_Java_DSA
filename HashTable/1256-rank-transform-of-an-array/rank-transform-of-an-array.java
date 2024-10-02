class Solution {
    /**
     * TC: O(2 x Nlog(N)) ~ O(Nlog(N))
     * SC: O(2K) ~ O(2N) ~ O(N)
     */
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] ranks = new int[n];
        TreeSet<Integer> ts = new TreeSet<Integer>(); // SC: O(K)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(K)
        for (int num : arr) { // TC: O(Nlog(N))
            ts.add(num);
        }
        int rank = 1;
        for (Integer key : ts) { // TC: O(Nlog(N))
            hm.put(key, rank);
            rank++;
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            ranks[i] = hm.get(arr[i]);
        }
        return ranks;
    }
}
