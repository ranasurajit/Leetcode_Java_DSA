class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String current = "";
        helper(n, 0, 0, result, current);
        return result;
    }

    private void helper(int n, int open, int closed, List<String> result, String current) {
        if (open == n && closed == n) {
            result.add(current);
        }
        if (open < n) {
            helper(n, open + 1, closed, result, current + "(");
        }
        if (closed < open) {
            helper(n, open, closed + 1, result, current + ")");
        }
    }
}