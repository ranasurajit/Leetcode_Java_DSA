class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<Integer>());
            }
            hm.get(nums[i]).add(i);
        }
        for (Integer key : hm.keySet()) {
            ArrayList<Integer> list = hm.get(key);
            int size = list.size();
            if (size > 1) {
                for (int i = size - 1; i >= 1; i--) {
                    int diff = list.get(i) - list.get(i - 1);
                    if (diff <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
