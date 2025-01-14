class Solution {
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        int p = 0; // pointer for array 'A'
        int q = 0; // pointer for array 'B'
        int[] result = new int[n];
        int index = 0;
        int count = 0;
        while (q < n) { // TC: O(N)
            map.put(A[p], map.getOrDefault(A[p], 0) + 1);
            map.put(B[q], map.getOrDefault(B[q], 0) + 1);
            if (A[p] == B[q]) {
                count++;
            } else {
                if (map.get(A[p]) == 2) {
                    count++;
                }
                if (map.get(B[q]) == 2) {
                    count++;
                }
            }
            result[index] = count;
            index++;
            p++;
            q++;
        }
        return result;
    }
}
