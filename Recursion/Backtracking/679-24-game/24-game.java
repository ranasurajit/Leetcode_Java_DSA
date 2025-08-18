class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    /**
     * Approach : Using Recursion + Backtracking Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<Double>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return solveRecursion(nums);
    }

    /**
     * Using Recursion + Backtracking Approach
     *
     * TC: O(1)
     * SC: O(1)
     */
    private boolean solveRecursion(List<Double> nums) {
        // Base Case
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }
        // Recursion
        for (int i = 0; i < nums.size(); i++) { // TC: O(4)
            for (int j = 0; j < nums.size(); j++) { // TC: O(4)
                if (i == j) {
                    // cannot perform operation on the same index
                    continue;
                }
                List<Double> next = new ArrayList<Double>();
                for (int k = 0; k < nums.size(); k++) { // TC: O(4)
                    if (i != k && j != k) {
                        next.add(nums.get(k));
                    }
                }
                for (Double val : computeOperation(nums.get(i), nums.get(j))) { // TC: O(1), SC: O(1)
                    // modify
                    next.add(val);
                    // explore
                    if (solveRecursion(next)) {
                        return true;
                    }
                    // backtrack
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }

    /**
     * Using Simulation Approach
     *
     * TC: O(1)
     * SC: O(6) ~ O(1)
     */
    private List<Double> computeOperation(double a, double b) {
        List<Double> operationValues = new ArrayList<Double>();
        operationValues.add(a + b);
        operationValues.add(a - b);
        operationValues.add(b - a);
        operationValues.add(a * b);
        if (Math.abs(b) > EPSILON) {
            operationValues.add(a / b);
        }
        if (Math.abs(a) > EPSILON) {
            operationValues.add(b / a);
        }
        return operationValues;
    }
}
