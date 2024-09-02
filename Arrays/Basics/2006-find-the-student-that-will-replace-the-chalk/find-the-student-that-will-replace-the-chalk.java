class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
        }
        long remChalks = k % sum;
        for (int i = 0; i < n; i++) {
            if (chalk[i] > remChalks) {
                return i;
            }
            remChalks = remChalks - chalk[i];
        }
        return -1;
    }
}
