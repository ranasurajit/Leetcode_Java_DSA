class Solution {
    /**
     * Approach III : Using Hashing Approach
     * 
     * TC: O(N x L)
     * SC: O(N)
     *
     * where L = average number of digit
     */
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int maxSize = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) { // TC: O(N)
            int sum = sumOfDigits(i); // TC: O(L)
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            int size = map.get(sum);
            if (size == maxSize) {
                count++;
            } else if (size > maxSize) {
                maxSize = size;
                // reset count if a new bigger size of sum of digits is observed
                count = 1;
            }
        }
        return count;
    }

    /**
     * Approach II : Using Hashing and Array-Pre-Processing Approach
     * 
     * TC: O(N x L + 2 x N) ~ O(N x L)
     * SC: O(2 x N) ~ O(N)
     *
     * where L = average number of digit
     */
    public int countLargestGroupApproachII(int n) {
        Map<Integer, ArrayList<Integer>> map = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        /**
         * As per constraints (1 <= n <= 10^4), 9999 has max sum of 36 
         */
        int[] sumDigits = new int[(int) 1e4 + 1];
        for (int i = 1; i <= n; i++) { // TC: O(N)
            sumDigits[i] = sumOfDigits(i); // TC: O(L)
        }
        for (int i = 1; i <= n; i++) { // TC: O(N)
            map.computeIfAbsent(sumDigits[i], k -> new ArrayList<Integer>()).add(i);
        }
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>(); // SC: O(N)
        int maxSize = 0;
        for (Integer key : map.keySet()) { // TC: O(N)
            int size = map.get(key).size();
            freq.put(size, freq.getOrDefault(size, 0) + 1);
            maxSize = Math.max(maxSize, size);
        }
        return freq.get(maxSize);
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(N x L + N) ~ O(N x L)
     * SC: O(2 x N) ~ O(N)
     *
     * where L = average number of digit
     */
    public int countLargestGroupApproachI(int n) {
        Map<Integer, ArrayList<Integer>> map = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 1; i <= n; i++) { // TC: O(N)
            int sum = sumOfDigits(i); // TC: O(L)
            map.computeIfAbsent(sum, k -> new ArrayList<Integer>()).add(i);
        }
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>(); // SC: O(N)
        int maxSize = 0;
        for (Integer key : map.keySet()) { // TC: O(N)
            int size = map.get(key).size();
            freq.put(size, freq.getOrDefault(size, 0) + 1);
            maxSize = Math.max(maxSize, size);
        }
        return freq.get(maxSize);
    }

    /**
     * TC: O(L)
     * SC: O(1)
     *
     * where L = average number of digit
     */
    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            int mod = num % 10;
            sum += mod;
            num = num / 10;
        }
        return sum;
    }
}
