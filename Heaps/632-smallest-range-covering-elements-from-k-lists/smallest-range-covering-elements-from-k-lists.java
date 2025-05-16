class Solution {
    /**
     * Approach : Using PriorityQueue (Min and Max Heaps) Approach
     *
     * TC: O(K + 2 x L x log(K)) ~ O(K + L x log(K))
     * SC: O(2 x K) ~ O(K)
     */
    public int[] smallestRange(List<List<Integer>> nums) {
        // we will create min and max heaps to determine the min and max for a kth list
        // we will store { element, listIndex } in min and max heaps
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p, q) -> p[0] - q[0]); // SC: O(K)

        int k = nums.size();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) { // TC: O(K)
            minHeap.offer(new int[] { nums.get(i).get(0), 0, i }); // TC: O(log(1))
            maxValue = Math.max(maxValue, nums.get(i).get(0));
        }
        int[] minRange = { minHeap.peek()[0], maxValue };
        int minDiff = Integer.MAX_VALUE;
        int startIndex = 0;
        while (!minHeap.isEmpty()) { // TC: O(L) where L = length of min size list in nums
            int[] current = minHeap.poll();
            int minValue = current[0];
            int idx = current[1];
            int listIndex = current[2];
            if (minDiff > maxValue - minValue) {
                minRange[0] = minValue;
                minRange[1] = maxValue;
                minDiff = maxValue - minValue;
                startIndex = idx;
            } else if (minDiff == maxValue - minValue && startIndex > idx) {
                minRange[0] = minValue;
                minRange[1] = maxValue;
                minDiff = maxValue - minValue;
                startIndex = idx;
            }
            if (idx + 1 < nums.get(listIndex).size()) {
                int newValue = nums.get(listIndex).get(idx + 1);
                minHeap.offer(new int[] { // TC: O(log(K))
                    newValue,
                    idx + 1,
                    listIndex
                });
                maxValue = Math.max(maxValue, newValue);
            } else {
                break;
            }
        }
        return minRange;
    }
}
