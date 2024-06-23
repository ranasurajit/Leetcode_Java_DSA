class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int result = 0;
        int left = 0;
        ArrayDeque<Integer> incDeque = new ArrayDeque<Integer>();
        ArrayDeque<Integer> decDeque = new ArrayDeque<Integer>();
        for (int right = 0; right < n; right++) {
            while (!incDeque.isEmpty() && nums[right] < incDeque.getLast()) {
                incDeque.removeLast();
            }
            while (!decDeque.isEmpty() && nums[right] > decDeque.getLast()) {
                decDeque.removeLast();
            }
            incDeque.addLast(nums[right]);
            decDeque.addLast(nums[right]);
            while (decDeque.getFirst() - incDeque.getFirst() > limit) {
                if (incDeque.getFirst() == nums[left]) {
                    incDeque.removeFirst();
                }
                if (decDeque.getFirst() == nums[left]) {
                    decDeque.removeFirst();
                }
                left++;
            }
            result = Math.max(result, (right - left + 1));
        }
        return result;
    }
}
