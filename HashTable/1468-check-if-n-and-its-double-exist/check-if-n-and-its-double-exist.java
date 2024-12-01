class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int item : arr) { // TC: O(N)
            if (hs.contains(item * 2) || (item % 2 == 0 && hs.contains(item / 2))) {
                return true;
            }
            hs.add(item);
        }
        return false;
    }
}
