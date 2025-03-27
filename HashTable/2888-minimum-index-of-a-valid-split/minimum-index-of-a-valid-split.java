class Solution {
    /**
     * Approach II : Using Boyer-Moore Majority Voting Algorithm (Constant Space)
     *
     * TC: O(3 x N) ~ O(N)
     * SC: O(1) - Constant Space
     */
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1;
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (count == 0) {
                dominant = nums.get(i);
                count = 1;
            } else if (nums.get(i) == dominant) {
                count++;
            } else {
                count--;
            }
        }
        int domFreq = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (nums.get(i) == dominant) {
                domFreq++;
            }
        }
        int countLeftDominant = 0;
        int countRightDominant = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            countLeftDominant += nums.get(i) == dominant ? 1 : 0;
            countRightDominant = domFreq - countLeftDominant;
            if (countLeftDominant > (i + 1) / 2 && countRightDominant > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach I : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int minimumIndexApproachI(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
        }
        int dominant = Integer.MIN_VALUE;
        int domFreq = 0;
        for (Integer key : map.keySet()) {
            if (domFreq < map.get(key)) {
                domFreq = map.get(key);
                dominant = key;
            }
        }
        int countLeftDominant = 0;
        int countRightDominant = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            countLeftDominant += nums.get(i) == dominant ? 1 : 0;
            countRightDominant = domFreq - countLeftDominant;
            if (countLeftDominant > (i + 1) / 2 && countRightDominant > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}
