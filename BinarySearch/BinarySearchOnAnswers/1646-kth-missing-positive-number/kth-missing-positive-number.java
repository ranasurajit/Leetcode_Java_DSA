class Solution {
    /**
     * Using Shifting
     *
     * TC: O(N)
     * SC: O(1)
     */
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }

    /**
     * Using HashSet
     *
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int findKthPositiveUsingHashSet(int[] arr, int k) {
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1];
        HashSet<Integer> hs = new HashSet<Integer>(); // SC: O(X) - (X + Y) = N
        HashSet<Integer> missing = new HashSet<Integer>(); // SC: O(Y) - (X + Y) = N
        for (int i = 0; i < n; i++) { // TC: O(N)
            hs.add(arr[i]);
        }
        int missed = -1;
        int count = 0;
        for (int i = low; i <= high; i++) { // TC: O(N)
            count = countOfMissing(hs, missing, i);
            if (count == k) {
                missed = i;
                break;
            }
        }
        if (count < k) {
            return arr[n - 1] + (k - count);
        }
        return missed;
    }

    private int countOfMissing(HashSet<Integer> hs, 
        HashSet<Integer> missing, int current) {
        if (!hs.contains(current)) {
            missing.add(current);
        }
        return missing.size();
    }
}
