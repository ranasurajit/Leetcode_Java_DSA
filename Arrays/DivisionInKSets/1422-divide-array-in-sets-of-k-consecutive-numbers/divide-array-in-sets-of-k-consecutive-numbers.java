class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        for (int it : nums) {
            treeMap.put(it, treeMap.getOrDefault(it, 0) + 1);
        }
        while (!treeMap.isEmpty()) {
            int min = treeMap.firstKey();
            for (int i = min; i < min + k; i++) {
                if (!treeMap.containsKey(i)) {
                    return false;
                }
                int count = treeMap.get(i);
                if (count == 1) {
                    treeMap.remove(i);
                } else {
                    treeMap.put(i, treeMap.get(i) - 1);
                }
            }
        }
        return true;
    }
}
