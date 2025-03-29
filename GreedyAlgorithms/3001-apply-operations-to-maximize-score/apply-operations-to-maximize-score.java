class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final int N = (int) 1e5;
    private int[] sieve = new int[N + 1];
    
    public int maximumScore(List<Integer> nums, int k) {
        buildSieve();
        int n = nums.size();
        
        int[] score = new int[n];
        for (int j = 0; j < n; j++) score[j] = primeScore(nums.get(j));
        
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int j = 0; j < n; j++) {
            while (!stack.isEmpty() && score[stack.peek()] < score[j]) stack.pop();
            left[j] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(j);
        }
        
        stack.clear();
        
        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && score[stack.peek()] <= score[j]) stack.pop();
            right[j] = stack.isEmpty() ? n : stack.peek();
            stack.push(j);
        }
        
        List<long[]> valAndFreq = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long possible = (i - left[i]) * (right[i] - i);
            valAndFreq.add(new long[]{nums.get(i), possible});
        }
        
        valAndFreq.sort((a, b) -> Long.compare(b[0], a[0]));
        
        long result = 1;
        for (long[] cur : valAndFreq) {
            if (k == 0) break;
            
            long take = Math.min(cur[1], (long) k);
            k -= take;
            result = (result * fastPower(cur[0], take)) % MOD;
        }
        
        return (int) result;
    }
    
    private void buildSieve() {
        Arrays.fill(sieve, 0);
        for (int j = 2; j * j <= N; j++) {
            for (int k = j; k <= N; k += j) {
                if (sieve[k] == 0) sieve[k] = j;
            }
        }
        for (int j = 1; j <= N; j++) {
            if (sieve[j] == 0) sieve[j] = j;
        }
    }
    
    private int primeScore(int x) {
        int result = 0;
        while (x != 1) {
            int div = sieve[x];
            while (x % div == 0) x /= div;
            result++;
        }
        return result;
    }
    
    private long fastPower(long x, long y) {
        long result = 1;
        while (y > 0) {
            if ((y & 1) == 1) result = (result * x) % MOD;
            x = (x * x) % MOD;
            y /= 2;
        }
        return result;
    }
}