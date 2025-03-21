class Solution {
    /**
     * Approach II : In place operation using Array Sorting Approach
     *
     * TC: O(N x log(N) + N) ~ O(N x log(N))
     * SC: O(1)
     */
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // TC: O(N x log(N))
        for (int i = 0; i < n - 1; i += 2) { // TC: O(N)
            // swap nums at index i and (i + 1)
            int temp = nums[i + 1];
            nums[i + 1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    /**
     * Approach I : Using PriorityQueue (Min-Heap) Approach
     *
     * TC: O(3 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int[] numberGameApproachI(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>((p, q) -> p - q); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pqMin.offer(nums[i]); // TC: O(log(N))
        }
        int index = 0;
        while (!pqMin.isEmpty()) { // TC: O(N)
            int[] pair = new int[] { pqMin.poll(), pqMin.poll() }; // TC: O(2 x log(N))
            result[index++] = pair[1];
            result[index++] = pair[0];
        }
        return result;
    }
}
