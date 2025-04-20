class Solution {
    /**
     * Approach II : Using Hashing Array Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int numRabbits(int[] answers) {
        int n = answers.length;
        int minRabbits = 0;
        int[] count = new int[1001]; // SC: O(1001) ~ O(1) as 0 <= answers[i] < 1000
        for (int i = 0; i < n; i++) {
            int countRabbits = answers[i] + 1;
            count[countRabbits]++;
            if (count[countRabbits] == countRabbits) {
                minRabbits += countRabbits;
                count[countRabbits] = 0;
            }
        }
        for (int i = 1; i < 1001; i++) { // TC: O(1000) ~ O(1)
            if (count[i] > 0) {
                minRabbits += i;
            }
        }
        return minRabbits;
    }

    /**
     * Approach I : Using Hashing (HashMap) Approach
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int numRabbitsApproachI(int[] answers) {
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
