class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        for (int i = 2; i < arr.length; i++) {
            if (isConsecutiveOdds(arr[i - 2], arr[i - 1], arr[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isConsecutiveOdds(int p, int q, int r) {
        return (p & 1) == 1 && (q & 1) == 1 && (r & 1) == 1;
    }
}
