class Solution {

    /**
     * Using Binary Search
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int it : piles) {
            high = Math.max(high, it);
        }
        int minSpeed = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long duration = minDuration(piles, mid);
            if (duration <= h) {
                minSpeed = Math.min(minSpeed, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    private long minDuration(int[] piles, int mid) {
        long duration = 0L;
        for (int i = 0; i < piles.length; i++) {
            long current = piles[i] % mid == 0 ? piles[i] / mid : (piles[i] / mid) + 1;
            duration += current;
        }
        return duration;
    }

    /**
     * Using Linear Search
     */
    // public int minEatingSpeed(int[] piles, int h) {
    //     int low = 1;
    //     int high = Integer.MIN_VALUE;
    //     for (int it : piles) {
    //         high = Math.max(high, it);
    //     }
    //     for (int i = low; i <= high; i++) {
    //         long duration = 0L;
    //         for (int j = 0; j < piles.length; j++) {
    //             long current = piles[j] % i == 0 ? piles[j] / i : (piles[j] / i) + 1;
    //             duration += current;
    //         }
    //         if (duration <= h) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
