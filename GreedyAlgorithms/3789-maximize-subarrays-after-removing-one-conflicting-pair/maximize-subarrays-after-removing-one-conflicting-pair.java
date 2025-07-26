class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N) + O(M) + O(N + M) + O(N) ~ O(M + N)
     * SC: O(N) + O(N) ~ O(N)
     *
     * where N = n and M = size(conflictingPairs)
     */
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long validSubarrays = 0L;
        // we will be creating a List which will store the conflicting number for any ending index
        List<List<Integer>> conflictList = new ArrayList<List<Integer>>(); // SC: O(N)
        for (int i = 0; i <= n; i++) { // TC: O(N)
            conflictList.add(new ArrayList<Integer>());
        }

        for (int[] pair : conflictingPairs) { // TC: O(M)
            int start = Math.min(pair[0], pair[1]);
            int end = Math.max(pair[0], pair[1]);
            conflictList.get(end).add(start);
        }

        int maxConflictNum = 0;
        int secondMaxConflictNum = 0;
        /**
         * we will be storing the number of extra sub-arrays for every 
         * end index if that conflict point is removed
         * loop through each index 'end' considering it as end element
         * of the valid sub-array
         */
        long[] extras = new long[n + 1]; // SC: O(N) as numbers are from 1 to n
        for (int end = 1; end <= n; end++) { // TC: O(N)
            for (int u : conflictList.get(end)) { // TC: O(M) - ammortized to 1 as this loop runs once
                if (u >= maxConflictNum) {
                    secondMaxConflictNum = maxConflictNum;
                    maxConflictNum = u;
                } else if (u >= secondMaxConflictNum && u != maxConflictNum) {
                    secondMaxConflictNum = u;
                }
            }
            validSubarrays += (end - maxConflictNum);
            // storing extra if maxConflictNum is removed
            extras[maxConflictNum] += maxConflictNum - secondMaxConflictNum;
        }
        long maxExtra = 0L;
        for (long e : extras) { // TC: O(N)
            maxExtra = Math.max(maxExtra, e);
        }
        return validSubarrays + maxExtra;
    }
}
