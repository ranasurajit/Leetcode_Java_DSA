class Solution {
    /**
     * Using Two Pointers
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0; // pointer for String 'start'
        int j = 0; // pointer for String 'target'
        while (i < n || j < n) {
            // skip underscores in the String 'start'
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            // skip underscores in the String 'target'
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            // if any pointer is exhaused check if other pointer is exhaused too
            if (i == n || j == n) {
                return i == n && j == n;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            // check for L position in 'start'
            if (start.charAt(i) == 'L' && i < j) {
                // L cannot move to right
                return false;
            }
            // check for R position in 'target'
            if (start.charAt(i) == 'R' && i > j) {
                // R cannot move to left
                return false;
            }
            // in other cases move i and j
            i++;
            j++;
        }
        return true;
    }

    /**
     * TC: Exponential
     * SC: O(N ^ 2)
     */
    public boolean canChangeUsingDP(String start, String target) {
        int n = start.length();
        HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
        return solve(start, target, n, memo);
    }

    private boolean solve(String start, String target, 
        int n, HashMap<String, Boolean> memo) {
        if (start.equals(target)) {
            return true;
        }
        if (memo.containsKey(start)) {
            return memo.get(start);
        }
        // trying all possibilities
        for (int i = 0; i < n; i++) {
            if (i > 0 && start.charAt(i) == 'L' && 
                start.charAt(i - 1) == '_') {
                String swapped = swap(start, i, i - 1);
                if (solve(swapped, target, n, memo)) {
                    return true;
                }
            } else if (i < n - 1 && start.charAt(i) == 'R' &&
                       start.charAt(i + 1) == '_') {
                String swapped = swap(start, i, i + 1);
                if (solve(swapped, target, n, memo)) {
                    return true;
                }
            }
        }
        memo.put(start, false);
        return false;
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
        return String.valueOf(chars);
    }
}
