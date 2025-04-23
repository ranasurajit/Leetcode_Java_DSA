class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N x L + N) ~ O(N x L)
     * SC: O(2 x N) ~ O(N)
     *
     * where L = average number of digit
     */
    public int countLargestGroup(int n) {
        Map<Integer, ArrayList<Integer>> map = 
            new HashMap<Integer, ArrayList<Integer>>(); // SC: O(N)
        for (int i = 1; i <= n; i++) { // TC: O(N)
            int sum = sumOfDigits(i); // TC: O(L)
            map.computeIfAbsent(sum, k -> new ArrayList<Integer>()).add(i);
        }
        // System.out.println(map);
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
