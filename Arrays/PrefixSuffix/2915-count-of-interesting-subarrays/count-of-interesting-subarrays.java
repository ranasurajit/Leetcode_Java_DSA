class Solution {
    /**
     * Approach III : Using Hashing Approach
     *
     * TC: O(N)
     * SC: O(N)
     *
     * Accepted (617 / 617 testcases passed)
     */
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long countSubarrays = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1);
        int prefixCount = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            prefixCount += nums.get(i) % modulo == k ? 1 : 0;
            prefixCount = prefixCount % modulo;
            int key = (prefixCount - k + modulo) % modulo;
            if (map.containsKey(key)) {
                countSubarrays += map.get(key);
            }
            map.put(prefixCount, map.getOrDefault(prefixCount, 0) + 1);
        }
        return countSubarrays;
    }

    /**
     * Approach II : Using Array Pre-Processing and Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     *
     * Accepted (617 / 617 testcases passed)
     */
    public long countInterestingSubarraysApproachII(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long countSubarrays = 0;
        int[] inteArray = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int value = nums.get(i) % modulo == k ? 1 : 0;
            inteArray[i] = value;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1);
        int prefixCount = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            prefixCount += inteArray[i];
            prefixCount = prefixCount % modulo;
            int key = (prefixCount - k + modulo) % modulo;
            if (map.containsKey(key)) {
                countSubarrays += map.get(key);
            }
            map.put(prefixCount, map.getOrDefault(prefixCount, 0) + 1);
        }
        return countSubarrays;
    }

    /**
     * Approach I : Brute-Force Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     *
     * Time Limit Exceeded (609 / 617 testcases passed)
     */
    public long countInterestingSubarraysApproachI(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        long countSubarrays = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int count = 0;
            for (int j = i; j < n; j++) { // TC: O(N)
                count += nums.get(j) % modulo == k ? 1 : 0;
                if (count % modulo == k) {
                    countSubarrays++;
                }
            }
        }
        return countSubarrays;
    }
}
