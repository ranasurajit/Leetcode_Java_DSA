class Solution {
    /**
     * Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int[] result = new int[n];
        int index = 0;
        int count = 0;
        while (index < n) { // TC: O(N)
            map.put(A[index], map.getOrDefault(A[index], 0) + 1);
            if (map.get(A[index]) == 2) {
                count++;
            }
            map.put(B[index], map.getOrDefault(B[index], 0) + 1);
            if (map.get(B[index]) == 2) {
                count++;
            } 
            result[index] = count;
            index++;
        }
        return result;
    }
}
