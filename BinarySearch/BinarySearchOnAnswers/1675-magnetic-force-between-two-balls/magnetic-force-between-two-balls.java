class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 0;
        int high = position[n - 1];
        int force = 0;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (possiblePlacingAllBalls(mid, position, m)) {
                force = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return force;
    }

    private boolean possiblePlacingAllBalls(int distance, int[] position, int m) {
        int count = 1;
        int last = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - last >= distance) {
                last = position[i];
                count++;
            }
        }
        return count >= m;
    }
}
