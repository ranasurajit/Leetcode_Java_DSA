class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> p - q);
        for (int i = 0; i < n; i++) {
            int[] prefix = prefixSum(nums, n, i);
            for (int j = 0; j < n - i; j++) {
                pq.offer(prefix[j]);
            }
        }
        int sum = 0;
        int count = 1;
        int mod = 1000000007;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            if (count >= left && count <= right) {
                sum = (sum % mod) + (current % mod);
            }
            count++;
        }
        return sum;
    }

    private int[] prefixSum(int[] nums, int n, int start) {
        int[] prefix = new int[n - start];
        prefix[0] = nums[start];
        int count = 1;
        for (int i = start + 1; i < n; i++) {
            prefix[count] = prefix[count - 1] + nums[i];
            count++;
        }
        return prefix;
    }
}
