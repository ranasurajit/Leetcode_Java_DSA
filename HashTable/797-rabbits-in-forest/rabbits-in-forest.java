class Solution {
    /**
     * Approach : Using Hashing Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numRabbits(int[] answers) {
        int n = answers.length;
        HashMap<Integer, Integer> rabbitMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            rabbitMap.put(answers[i], rabbitMap.getOrDefault(answers[i], 0) + 1);
        }
        int minRabbits = 0;
        for (Integer key : rabbitMap.keySet()) { // TC: O(N)
            int count = rabbitMap.get(key);
            double size = key + 1; // size is always answers[i] + 1 (including itself)
            double groups = Math.ceil(count / size);
            minRabbits += groups * size;
        }
        return minRabbits;
    }
}
