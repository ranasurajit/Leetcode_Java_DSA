class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Using Multiple Approaches (Greedy + Monotonic Stack Approach)
     *
     * - Next and Previous Greater Elements Using Monotonic Stack
     * - Prime Factorization Approach
     * - Fast Power Approach
     * 
     * TC: O(N x Sqrt(N) + O(3 x N) + (N + K) x log(N)) ~ O(N x Sqrt(N) + (N + K) x log(N))
     * SC: O(4 x N + K x log(N)) ~ O(N + K x log(N))
     */
    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        long[] scores = new long[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            scores[i] = computePrimeScore(nums.get(i)); // TC: O(Sqrt(N))
        }
        Stack<Integer> st = new Stack<>();
        long[] pge = previousGreaterElements(n, scores, st); // TC: O(N), SC: O(N)
        st.clear();
        long[] nge = nextGreaterElements(n, scores, st); // TC: O(N), SC: O(N)

        // Pre-computing possible counts of sub-arrays possibile for any index
        List<long[]> valAndFreq = new ArrayList<>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            long possible = (i - pge[i]) * (nge[i] - i);
            valAndFreq.add(new long[]{ nums.get(i), possible });
        }
        // Sorting the possibilities in descending order of value of nums
        valAndFreq.sort((a, b) -> Long.compare(b[0], a[0])); // TC: O(N x log(N))
        
        long result = 1;
        for (long[] cur : valAndFreq) { // TC: O(K)
            if (k == 0) break;
            long take = Math.min(cur[1], (long) k);
            k -= take;
            result = (result * fastPower(cur[0], take)) % MOD; // TC: O(log(N)), SC: O(log(N))
        }
        return (int) result;
    }

    /**
     * Using Calculation of Previous Greater Element Using Monotonic Stack
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private long[] previousGreaterElements(int n, long[] scores, Stack<Integer> st) {
        long[] pge = new long[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && scores[st.peek()] < scores[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    /**
     * Using Calculation of Next Greater Element Using Monotonic Stack
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private long[] nextGreaterElements(int n, long[] scores, Stack<Integer> st) {
        long[] nge = new long[n]; // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (!st.isEmpty() && scores[st.peek()] <= scores[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    /**
     * Method to get Prime Score of a number
     *
     * TC: O(Sqrt(N))
     * SC: O(N)
     */
    private long computePrimeScore(int num) {
        long count = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                count++;
                while (num % i == 0) {
                    num = num / i;
                }
            }
        }
        if (num > 1) {
            count++;
        }
        return count;
    }
    
    /**
     * Using Fast Power Approach
     *
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private long fastPower(long x, long n) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Recursive Calls
        long half = fastPower(x, n / 2);
        long result = (half * half) % MOD;
        if ((n & 1) == 1) {
            // n is odd
            result = (x * result) % MOD;
        }
        return result;
    }
}
