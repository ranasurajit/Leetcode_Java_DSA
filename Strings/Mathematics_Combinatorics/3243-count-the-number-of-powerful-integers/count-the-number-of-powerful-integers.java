class Solution {
    /**
     * Approach : Using Mathematics and Combinatorics Approach
     *
     * TC: O((N - M) x log(limit))
     * SC: O(1)
     */
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String startStr = String.valueOf(start - 1);
        String finishStr = String.valueOf(finish);
        return solve(finishStr, limit, s) - solve(startStr, limit, s);
    }

    /**
     * This method would return all the powerful integers from range (0 to finish)
     *
     * TC: O((N - M) x log(limit))
     * SC: O(1) 
     */
    private long solve(String finish, int limit, String suffix) {
        if (finish.length() < suffix.length()) {
            return 0L;
        }
        long count = 0L;
        int prefixLength = finish.length() - suffix.length();
        String trailing = finish.substring(prefixLength);
        for (int i = 0; i < prefixLength; i++) { // TC: O(N - M)
            int digit = finish.charAt(i) - '0';
            if (digit <= limit) {
                count += digit * Math.pow(limit + 1, prefixLength - i - 1); // TC: log(limit)
            } else {
                // we need to count next subsequent digits after index i
                count += Math.pow(limit + 1, prefixLength - i); // TC: log(limit)
                return count;
            }
        }
        if (trailing.compareTo(suffix) >= 0) {
            count++;
        }
        return count;
    }
}
