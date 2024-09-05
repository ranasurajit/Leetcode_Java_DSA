class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] missing = new int[n];
        int m = rolls.length;
        long sum = 0L;
        for (int it : rolls) {
            sum += it;
        }
        long missingSum = mean * (m + n) - sum;
        if (missingSum < n || missingSum > n * 6) {
            return new int[]{};
        }
        int count = missing.length;
        int index = 0;
        while (missingSum != 0) {
            int roll = (int) missingSum / count--;
            missing[index++] = roll;
            missingSum = missingSum - roll;
        }
        return missing;
    }
}
