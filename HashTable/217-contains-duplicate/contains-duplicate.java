class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                return true;
            }
            hm.put(nums[i], i);
        }
        return false;
    }
}
