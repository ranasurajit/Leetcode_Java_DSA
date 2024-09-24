class Solution {
    /**
     * TC: O(M x log10(M) + N x log10(N))
     * SC: O(M x log10(M))
     */
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(M)
        for (int it : arr1) { // TC: O(M)
            while (!hs.contains(it) && it > 0) { // TC: O(D), where D = number of digits O(log10(M))
                hs.add(it);
                it = it / 10;
            }
        }
        int result = 0;
        for (int it : arr2) { // TC: O(N)
            while (!hs.contains(it) && it > 0) { // TC: O(D), where D = number of digits O(log10(N))
                it = it / 10;
            }
            if (it > 0) {
                result = Math.max(result, (int) Math.log10(it) + 1);
            }
        }
        return result;
    }
}
