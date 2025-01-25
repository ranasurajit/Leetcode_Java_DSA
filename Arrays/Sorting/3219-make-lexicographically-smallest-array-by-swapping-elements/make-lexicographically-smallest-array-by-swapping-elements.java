class Solution {
    /**
     * Optimal Approach
     *
     * TC: O(N x log(N) + 3 x N) ~ O(N x log(N))
     * SC: O(3 x N) ~ O(N)
     */
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = nums.clone();                            // TC: O(N), SC: O(N)
        Arrays.sort(sorted);                                    // TC: O(N x log(N))
        Map<Integer, Integer> groupMap = new HashMap<Integer, Integer>(); // SC: O(N)
        // took a HashMap data-structure to store <Key, Queue>
        Map<Integer, LinkedList<Integer>> groupList =
            new HashMap<Integer, LinkedList<Integer>>();                  // SC: O(N)
        // adding the first element from sorted array to above maps
        int groupKey = 0;
        groupMap.put(sorted[0], groupKey);
        groupList.putIfAbsent(groupKey, new LinkedList<Integer>());
        groupList.get(groupKey).add(sorted[0]);

        // processing rest elements from sorted to form groups
        for (int i = 1; i < n; i++) {                          // TC: O(N)
            if (Math.abs(sorted[i] - sorted[i - 1]) > limit) {
                groupKey++;
            }
            groupMap.put(sorted[i], groupKey);
            groupList.putIfAbsent(groupKey, new LinkedList<Integer>());
            groupList.get(groupKey).add(sorted[i]);
        }
        // create the result array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {                         // TC: O(N)
            int group = groupMap.get(nums[i]);
            result[i] = groupList.get(group).pollFirst();
        }
        return result;
    }

    /**
     * Brute-Force Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public int[] lexicographicallySmallestArrayBruteForce(int[] nums, int limit) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {             // TC: O(N)
            while (true) {                        // TC: O(N)
                int idx = -1;
                int smallValue = nums[i];
                for (int j = i + 1; j < n; j++) { // TC: O(N)
                    if (nums[j] < smallValue && smallValue - nums[j] <= limit) {
                        smallValue = nums[j];
                        idx = j;
                    }
                }
                if (idx != -1) {
                    // swap
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i] = temp;
                } else {
                    break;
                }
            }
        }
        return nums;
    }
}
