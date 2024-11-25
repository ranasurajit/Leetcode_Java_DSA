class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 1;
        int high = arr[n - 1];
        HashSet<Integer> hs = new HashSet<Integer>();
        HashSet<Integer> missing = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hs.add(arr[i]);
        }
        int missed = -1;
        int count = 0;
        for (int i = low; i <= high; i++) {
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
