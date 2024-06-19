class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long total = (long) m * (long) k;
        if (n < total) {
            return -1;
        }
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, bloomDay[i]);
            maxVal = Math.max(maxVal, bloomDay[i]);
        }
        int low = minVal;
        int high = maxVal;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (canBouquetsFormed(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canBouquetsFormed(int[] bloomDay, int day, int m, int k) {
        int count = 0;
        int bouquets = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                count++;
            } else {
                bouquets += count / k;
                count = 0;
            }
        }
        bouquets += count / k;
        return bouquets >= m;
    }
}
