class Solution {
    /**
     * Approach : Using Sliding Window Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public String largestGoodInteger(String num) {
        int n = num.length();
        // HashMap can have only size upto 10 (digits 0 - 9)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(10) ~ O(1)
        int i = 0;
        int j = 0;
        String maxValue = "-1";
        while (j < n) { // TC: O(N)
            int digit = num.charAt(j) - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
            if (j - i + 1 < 3) {
                j++;
            } else if (j - i + 1 == 3) {
                if (map.size() == 1 && 
                    Integer.valueOf(num.substring(i, j + 1)) > Integer.valueOf(maxValue)) {
                    maxValue = num.substring(i, j + 1);
                }
                // removing computation from index 'i'
                int prevDigit = num.charAt(i) - '0';
                map.put(prevDigit, map.getOrDefault(prevDigit, 0) - 1);
                if (map.get(prevDigit) == 0) {
                    map.remove(prevDigit);
                }
                // move to next window
                i++;
                j++;
            }
        }
        if (maxValue == "-1") {
            return "";
        }
        return maxValue;
    }
}
