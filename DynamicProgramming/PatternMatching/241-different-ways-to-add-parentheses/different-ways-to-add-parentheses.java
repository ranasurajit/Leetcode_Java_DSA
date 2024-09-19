class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        return recurCompute(expression, 0, n - 1, dp);
    }

    private List<Integer> recurCompute(String exp, int start, int end, List<Integer>[][] dp) {
        List<Integer> result = new ArrayList<Integer>();
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        // base case 
        // single digit
        if (start == end) {
            int num = exp.charAt(start) - '0';
            result.add(num);
            return result;
        }
        // double digit
        if (end - start == 1 && Character.isDigit(exp.charAt(start))) {
            int num1 = exp.charAt(start) - '0';
            int num2 = exp.charAt(end) - '0';
            result.add(num1 * 10 + num2);
            return result;
        }
        // split with operators
        for (int i = start; i <= end; i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                continue;
            }
            List<Integer> left = recurCompute(exp, start, i - 1, dp);
            List<Integer> right = recurCompute(exp, i + 1, end, dp);
            for (Integer l : left) {
                for (Integer r : right) {
                    if (ch == '*') {
                        result.add(l * r);
                    } else if (ch == '+') {
                        result.add(l + r);
                    } if (ch == '-') {
                        result.add(l - r);
                    }
                }
            }
        }
        dp[start][end] = result;
        return dp[start][end];
    }
}
