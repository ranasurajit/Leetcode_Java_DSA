class Solution {
    public int reverse(int x) {
        long rev = 0;
        int neg = x < 0 ? -1 : 1;
        int n = neg * x;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            rev = rev * 10 + temp;
        }
        if (rev > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) rev * neg;
    }
}
