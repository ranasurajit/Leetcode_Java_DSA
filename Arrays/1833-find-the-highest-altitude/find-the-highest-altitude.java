class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int alt = 0;
        for (int val : gain) {
            alt += val;
            max = Math.max(max, alt);
        }
        return max;
    }
}
