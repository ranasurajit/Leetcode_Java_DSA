class Solution {
    /**
     * Optimal Approach: Using Fixed Size Array
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int maximumSum(int[] nums) {
        int n = nums.length;
        /**
         * max-sum value possible is 999999999 = 81 
         * as per constraints 1 <= nums[i] <= 109
         * so we can take array of fixed size 82
         */
        int[] sumMap = new int[82];
        int maxSum = -1;
        for (int i = 0; i < n; i++) {   // TC: O(N)
            int key = getSumOfDigits(nums[i]);
            if (sumMap[key] > 0) {
                maxSum = Math.max(maxSum, sumMap[key] + nums[i]);
            }
            sumMap[key] = Math.max(sumMap[key], nums[i]);
        }
        return maxSum;
    }

    /**
     * Better Approach: Using HashMap and Max-Heap(PriorityQueue)
     *
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int maximumSumApproachII(int[] nums) {
        int n = nums.length;
        Map<Integer, PriorityQueue<Integer>> sumMap =
            new HashMap<Integer, PriorityQueue<Integer>>(); // SC: O(N)
        for (int i = 0; i < n; i++) {   // TC: O(N)
            int key = getSumOfDigits(nums[i]);
            sumMap.computeIfAbsent(key, // TC: O(log(N))
                k -> new PriorityQueue<Integer>((p, q) -> q - p)).offer(nums[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (Integer key : sumMap.keySet()) { // TC: O(N)
            PriorityQueue pq = sumMap.get(key);
            if (pq.size() >= 2) {
                int first = (int) pq.poll();  // TC: O(log(N))
                int second = (int) pq.poll(); // TC: O(log(N))
                maxSum = Math.max(maxSum, first + second);
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int maximumSumApproachIII(int[] nums) {
        int n = nums.length;
        int[] numSum = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            numSum[i] = getSumOfDigits(nums[i]);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (numSum[i] == numSum[j]) {
                    maxSum = Math.max(maxSum, nums[i] + nums[j]);
                }
            }
        }
        return maxSum == Integer.MIN_VALUE ? -1 : maxSum;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            num = num / 10;
            sum += rem;
        }
        return sum;
    }
}
