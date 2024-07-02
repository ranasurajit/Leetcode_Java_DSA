class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int it : nums1) {
            hm.put(it, hm.getOrDefault(it, 0) + 1);
        }
        for (int it : nums2) {
            if (hm.containsKey(it)) {
                if (hm.get(it) == 1) {
                    hm.remove(it);
                } else {
                    hm.put(it, hm.get(it) - 1);
                }
                list.add(it);
            }
        }
        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
