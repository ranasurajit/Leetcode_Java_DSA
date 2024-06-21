class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int minSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                minSatisfied += customers[i];
            }
        }
        int maxSatisfied = minSatisfied;
        int index = 0;
        int delta = 0;
        while (index < n - minutes + 1) {
            for (int i = index; i < minutes + index; i++) {
                if (grumpy[i] == 1) {
                    delta += customers[i];
                }
            }
            maxSatisfied = Math.max(maxSatisfied, minSatisfied + delta);
            delta = 0;
            index++;
        }
        return maxSatisfied;
    }
}
