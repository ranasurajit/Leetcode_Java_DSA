class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        // Iterate through all ordered pairs (a, b) with a != b, digits '0'–'4'
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) continue;

                // minDiff[pA][pB] = minimum (countA – countB) seen at parity state (pA, pB)
                int[][] minDiff = new int[2][2];
                for (int[] row : minDiff)
                    Arrays.fill(row, Integer.MAX_VALUE / 2);

                int countA = 0, countB = 0;
                int prevA = 0, prevB = 0;
                int left = -1;

                // Slide right pointer across string
                for (int right = 0; right < n; ++right) {
                    if (s.charAt(right) == a) countA++;
                    if (s.charAt(right) == b) countB++;

                    // While window length >= k and both a and b occurred in existing window
                    while (right - left >= k
                            && countA - prevA > 0
                            && countB - prevB > 0) {
                        int pA = prevA % 2;
                        int pB = prevB % 2;
                        minDiff[pA][pB] = Math.min(minDiff[pA][pB], prevA - prevB);

                        left++;
                        if (s.charAt(left) == a) prevA++;
                        if (s.charAt(left) == b) prevB++;
                    }

                    int cPA = countA % 2;
                    int cPB = countB % 2;
                    // We want countA odd → flip parity, countB even → parity stays
                    int neededMin = minDiff[1 - cPA][cPB];
                    ans = Math.max(ans, countA - countB - neededMin);
                }
            }
        }
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
