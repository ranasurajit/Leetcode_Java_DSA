class Solution {
    /**
     * TC: O(N x log(K) + K x log(K)) ~ O(N x log(K))
     * SC: O(K)
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair p, Pair q) -> p.value - q.value); // SC: O(K)
        // Creating initial range from all lists;
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) { // TC: O(K)
            pq.offer(new Pair(nums.get(i).get(0), i, 0)); // TC: O(log(K))
            maxElement = Math.max(maxElement, nums.get(i).get(0));
        }
        int[] range = { -1000000, 1000000 };
        while (!pq.isEmpty()) { // TC: O(N)
            Pair current = pq.poll(); // TC: O(log(K))
            int minElement = current.value;
            int currListIdx = current.listIdx;
            int currIdx = current.idx;
            // compare for the smallest range
            if (maxElement - minElement < range[1] - range[0]) {
                range[0] = minElement;
                range[1] = maxElement;
            } else if (maxElement - minElement == range[1] - range[0] && range[0] > minElement) {
                range[0] = minElement;
                range[1] = maxElement;
            }
            if (currIdx + 1 < nums.get(currListIdx).size()) {
                int newValue = nums.get(currListIdx).get(currIdx + 1);
                pq.offer(new Pair(newValue, currListIdx, currIdx + 1)); // TC: O(log(K))
                maxElement = Math.max(maxElement, newValue);
            } else {
                break;
            }
        }
        return range;
    }
}

class Pair {
    int value;
    int listIdx;
    int idx;
    public Pair (int value, int listIdx, int idx) {
        this.value = value;
        this.listIdx = listIdx;
        this.idx = idx;
    }
}
