class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     *
     * TC: O(N)
     * SC: O(2) ~ O(1) as we have only two baskets (HashMap size)
     */
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(2)
        int i = 0;
        int j = 0;
        int maxTrees = 0;
        while (j < n) { // TC: O(N)
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if (map.size() > 2) {
                // we need to remove computation from index 'i'
                map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            // at this point maximum two baskets are present
            maxTrees = Math.max(maxTrees, j - i + 1);
            j++;
        }
        return maxTrees;
    }
}
