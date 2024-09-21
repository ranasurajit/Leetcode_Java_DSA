class Solution {
    /**
     * TC: O(N) - visits exactly one number till N
     * SC: O(K) - K is number of digits in n (recursive stack)
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> order = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            solve(i, n, order);
        }
        return order;
    }

    private void solve(int current, int n, List<Integer> order) {
        // Base case
        if (current > n) {
            return;
        }
        order.add(current);
        // append number 0 to 9 to current
        for (int i = 0; i <= 9; i++) {
            int newNum = current * 10 + i;
            if (newNum > n) {
                return;
            }
            solve(newNum, n, order);
        }
    }
}
