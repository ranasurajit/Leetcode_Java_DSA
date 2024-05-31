class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int it : nums) {
            xor = xor ^ it;
        }
        int diffBit = 1;
        int[] singles = new int[2];
        int a = 0, b = 0;
        // finding right most set bit for xor
        int rightSetBit = xor & -xor;
        // segregating numbers and applying xor based upon if num has bit on/off at index = rightSetBit
        for (int it : nums) {
            if ((rightSetBit & it) == 0) {
                a = a ^ it;
            } else {
                b = b ^ it;
            }
        }
        singles[0] = a < b ? a : b;
        singles[1] = a < b ? b : a;
        return singles;
    }
}
