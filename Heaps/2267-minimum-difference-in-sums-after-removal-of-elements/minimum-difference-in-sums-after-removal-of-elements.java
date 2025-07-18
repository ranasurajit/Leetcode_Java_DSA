class Solution {
    /**
     * Approach : Using Heaps + Array Pre-Processing Approach
     *
     * TC: O(N x log(N))
     * SC: O(N)
     */
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        /**
         * We need to divide the array into two parts such that sum(first) is as minimum as possible
         * and sum(second) is as maximum as possible, so we will use Max-Heap to push sum(first) and
         * Min-Heap to push sum(second)
         */
        PriorityQueue<Long> maxPQ = new PriorityQueue<Long>((p, q) -> Long.compare(q, p)); // SC: O(N / 3)
        PriorityQueue<Long> minPQ = new PriorityQueue<Long>(); // SC: O(N / 3)
        List<Long> sumFirstPrefix = new ArrayList<Long>(); // SC: O(N / 3)
        List<Long> sumSecondPrefix = new ArrayList<Long>(); // SC: O(N / 3)
        long minSum = 0L;
        for (int i = 0; i < n / 3; i++) { // TC: O(N / 3)
            minSum += (long) nums[i];
            maxPQ.offer((long) nums[i]); // TC: O(log(N / 3))
        }
        long maxSum = 0;
        for (int i = n - 1; i >= 2 * (n / 3); i--) { // TC: O(N / 3)
            maxSum += (long) nums[i];
            minPQ.offer((long) nums[i]); // TC: O(log(N / 3))
        }
        sumFirstPrefix.add(minSum);
        sumSecondPrefix.add(maxSum);

        // First Pass - filling up maxPQ iterating from left to right
        int p = n / 3;
        for (int i = p; i < 2 * p; i++) { // TC: O(N / 3)
            if (nums[i] < maxPQ.peek()) {
                minSum -= maxPQ.poll();
                minSum += (long) nums[i];
                maxPQ.offer((long) nums[i]); // TC: O(log(N / 3))
            }
            sumFirstPrefix.add(minSum);
        }
        // Second Pass - filling up minPQ iterating from right to left
        for (int i = (2 * p - 1); i >= p; i--) { // TC: O(N / 3)
            if (nums[i] > minPQ.peek()) {
                maxSum -= minPQ.poll();
                maxSum += (long) nums[i];
                minPQ.offer((long) nums[i]); // TC: O(log(N / 3))
            }
            sumSecondPrefix.add(maxSum);
        }
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < sumFirstPrefix.size(); i++) { // TC: O(N / 3)
            minDiff = Math.min(minDiff, 
                sumFirstPrefix.get(i) - sumSecondPrefix.get(sumSecondPrefix.size() - 1 - i));
        }
        return minDiff;
    }
}
