class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return twoSumBruteForce(nums, target);
        // return twoSumBetter(nums, target);
        return twoSumOptimal(nums, target);
    }

    /**
     * Optimal Approach (Using HashMap)
     * TC: O(N)
     * SC: O(N)
     */
    private int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int diff = target - nums[i];
            if (hm.containsKey(diff)) {
                return new int[]{ hm.get(diff), i };
            }
            hm.put(nums[i], i);
        }
        return new int[]{ -1, -1 };
    }

    /**
     * Better Approach (Using Two Pointers)
     * TC: O(2N + Nlog(N)) ~ O(Nlog(N))
     * SC: O(2N) ~ O(N)
     */
    private int[] twoSumBetter(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        Map<Integer, ArrayList<Integer>> dup = new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], i);
            } else {
                dup.put(nums[i], new ArrayList<Integer>());
                dup.get(nums[i]).add(hm.get(nums[i]));
                dup.get(nums[i]).add(hm.get(i));
                hm.put(nums[i], i);
            }
        }
        Arrays.sort(nums); // TC: O(Nlog(N))
        int p = 0;
        int q = n - 1;
        while (p < q) { // TC: O(N)
            if (nums[p] + nums[q] == target) {
                int index1 = hm.get(nums[p]);
                int index2 = hm.get(nums[q]);
                if (nums[p] == nums[q]) {
                    index1 = dup.get(nums[p]).get(0);
                }
                return new int[]{ index1, index2 };
            } else if (nums[p] + nums[q] < target) {
                p++;
            } else {
                q--;
            }
        }
        return new int[]{ -1, -1 };
    }

    /**
     * Brute-Force Approach
     * TC: O(N^2)
     * SC: O(1)
     */
    private int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{ i, j };
                }
            }
        }
        return new int[]{ -1, -1 };
    }
}
