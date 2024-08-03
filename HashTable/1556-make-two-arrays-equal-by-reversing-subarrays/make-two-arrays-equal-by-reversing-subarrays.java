class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // return canBeEqualBySorting(target, arr);
        return canBeEqualByHashing(target, arr);
    }

    /**
     * TC: O(2N) ~ O(N)
     * SC: O(N)
     */
    private boolean canBeEqualByHashing(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            hm.put(target[i], hm.getOrDefault(target[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int count = hm.getOrDefault(arr[i], 0);
            if (count == 1) {
                hm.remove(arr[i]);
            } else {
                count = count - 1;
                hm.put(arr[i], count);
            }
        }
        return hm.isEmpty();
    }

    /**
     * TC: O(NlogN + N) ~ O(NlogN)
     * SC: O(1)
     */
    private boolean canBeEqualBySorting(int[] target, int[] arr) {
        int n = target.length;
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
