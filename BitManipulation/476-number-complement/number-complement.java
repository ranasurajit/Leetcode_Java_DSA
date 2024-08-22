class Solution {
    public int findComplement(int num) {
        int bits = countBits(num);
        int index = 0;
        while (index < bits) {
            num = num ^ (1 << index);
            index++;
        }
        return num;
    }

    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            n = n >> 1;
            count++;
        }
        return count;
    }

    // private int solve(int num) {
    //     String s = "";
    //     int ans = 0;
    //     int count = 0;
    //     while (num > 0) {
    //         int rem = num % 2;
    //         s = rem + s;
    //         num = num / 2;
    //         int bit = rem == 0 ? 1 : 0;
    //         ans = ans + (int) (Math.pow(2, count) * bit);
    //         count++;
    //     }
    //     return ans;
    // }
}
