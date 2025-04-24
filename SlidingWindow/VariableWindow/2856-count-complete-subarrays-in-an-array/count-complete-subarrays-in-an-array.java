class Solution {
    /**
     * Approach II : Sliding Window (Variable Size) Approach Using Hashing
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            set.add(num);
        }
        int k = set.size(); // number of distinct elements in the array 'nums'
        int count = 0;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        while (j < n) { // TC: O(N)
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() >= k) {
                if (map.size() == k) {
                    /**
                     * when we get index j then all indices from j till n 
                     * will satisfy the condition of complete subarrays
                     */
                    count += (n - j);
                }
                // remove calculations from index i
                int freq = map.get(nums[i]);
                if (freq == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i]) - 1);
                }
                // shrink the window
                i++;
            }
            j++;
        }
        return count;
    }

    /**
     * Approach I : Brute-Force Approach Using Hashing
     *
     * TC: O(N + N ^ 2) ~ O(N ^ 2)
     * SC: O(N)
     */
    public int countCompleteSubarraysApproachI(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int num : nums) { // TC: O(N)
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int k = map.size(); // number of distinct elements in the array 'nums'
        map.clear();
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i; j < n; j++) { // TC: O(N)
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.size() == k) {
                    count++;
                }
            }
            map.clear(); // clearing map for next iteration
        }
        return count;
    }
}
