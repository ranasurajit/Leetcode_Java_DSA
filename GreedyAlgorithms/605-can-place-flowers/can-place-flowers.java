class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int fi = -1;
        int li = -1;
        int max = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (fi == -1) {
                    fi = i;
                    li = i;
                } else {
                    li = i;
                }
            }
        }
        // if flowerbed has all zeros
        if (fi == -1) {
            max = (flowerbed.length + 1) / 2;
        } else {
            // max = number of leading/following zeros / 2 
            max += (fi / 2) + ((flowerbed.length - li - 1) / 2);
            // count middle zeros
            int count = 0;
            for (int i = fi + 1; i < li; i++) {
                if (flowerbed[i] == 0) {
                    count++;
                } else {
                    max += (count - 1) / 2;
                    count = 0;
                }
            }
            // still left count to add in max
            max += (count - 1) / 2;
        }
        return n <= max;
    }
}
