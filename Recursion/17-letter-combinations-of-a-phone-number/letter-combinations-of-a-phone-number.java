class Solution {
    private static final String[] keyPad = { 
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz" 
    };

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> result = new ArrayList<String>();
        if (digits.equals("")) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        solveRecursion(0, n, digits, sb, result);
        return result;
    }

    private void solveRecursion(int idx, int n, String digits, 
        StringBuilder sb, List<String> result) {
        // Base Case
        if (idx == n) {
            result.add(sb.toString());
            return;
        }
        // Recursion Calls
        char ch = digits.charAt(idx);
        String keys = keyPad[ch - '0'];
        if (keys.length() > 0) {
            for (char c : keys.toCharArray()) {
                sb.append(c);
                solveRecursion(idx + 1, n, digits, sb, result);
                sb.setLength(sb.length() - 1); // backtrack to explore other possibilities
            }
        }
    }
}
