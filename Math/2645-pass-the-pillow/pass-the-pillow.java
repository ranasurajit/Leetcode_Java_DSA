class Solution {
    public int passThePillow(int n, int time) {
        int start = 1;
        boolean fwd = true;
        while (time > 0) {
            if (start == 1) {
                fwd = true;
            }
            if (start == n) {
                fwd = false;
            }
            if (fwd) {
                start++;
            } else {
                start--;
            }
            time--;
        }
        return start;
    }
}
