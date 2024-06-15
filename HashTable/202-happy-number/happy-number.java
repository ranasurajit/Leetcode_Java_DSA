class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hs = new HashSet<Integer>();
        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            // if n != 1, we need to update n with sum so that the process continues
            n = sum;
            if (hs.contains(n)) {
                return false;
            }
            hs.add(n);
        }
    }
}
