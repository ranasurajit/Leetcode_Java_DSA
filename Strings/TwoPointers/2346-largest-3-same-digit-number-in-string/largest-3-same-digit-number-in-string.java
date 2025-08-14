class Solution {
    /**
     * Approach III : Using String Simulation (Optimal) Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public String largestGoodInteger(String num) {
        int n = num.length();
        String[] strList = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
        for (String s : strList) { // TC: O(10)
            if (num.contains(s)) { // TC: O(N)
                return s;
            }
        }
        return "";
    }

    /**
     * Approach II : Using String Simulation Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public String largestGoodIntegerStringSimulation(String num) {
        int n = num.length();
        String maxValue = "-1";
        for (int i = 2; i < n; i++) { // TC: O(N)
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                if (Integer.valueOf(num.substring(i - 2, i + 1)) > Integer.valueOf(maxValue)) {
                    maxValue = num.substring(i - 2, i + 1);
                }
            }
        }
        if (maxValue == "-1") {
            return "";
        }
        return maxValue;
    }

    /**
     * Approach I : Using Sliding Window Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public String largestGoodIntegerSlidingWindow(String num) {
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
