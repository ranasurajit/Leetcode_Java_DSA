class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int windows = 0;
        for (int i = 0; i < 3 && i < arr.length; i++) {
            windows += (arr[i] & 1) == 1 ? 1 : 0;
        }
        if (windows == 3) {
            return true;
        }
        for (int i = 3; i < arr.length; i++) {
            windows -= (arr[i - 3] & 1) == 1 ? 1 : 0;
            windows += (arr[i] & 1) == 1 ? 1 : 0;
            if (windows == 3) {
                return true;
            }
        }
        return false;
    }
}
