class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        if (len == 0) {
            return "";
        }
        List<Long> list = new ArrayList<Long>();
        boolean isOdd = len % 2 == 1;
        int mid = isOdd ? (len / 2 + 1) : (len / 2);
        Long firstHalf = Long.parseLong(n.substring(0, mid));
        list.add(getNearestPalindrome(firstHalf, isOdd));
        list.add(getNearestPalindrome(firstHalf - 1, isOdd)); // 121 -> 12 1 -> 12 - 1 1 -> 111
        list.add(getNearestPalindrome(firstHalf + 1, isOdd)); // 121 -> 12 1 -> 12 + 1 1 -> 131
        list.add((long) Math.pow(10, len - 1) - 1); // cases of 9's
        list.add((long) Math.pow(10, len) + 1); // cases of 101, 1001, 10001

        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long result = Long.MAX_VALUE;
        for (Long it : list) {
            if (it == num) {
                continue;
            } else {
                if (Math.abs(it - num) < minDiff) {
                    minDiff = Math.abs(it - num);
                    result = it;
                } else if (Math.abs(it - num) == minDiff) {
                    result = Math.min(result, it);
                }
            }
        }
        return String.valueOf(result);
    }

    private long getNearestPalindrome(long firstHalf, boolean isOdd) {
        long result = firstHalf; // 122 -> 12 2 21
        if (isOdd) {
            firstHalf = firstHalf / 10;
        }
        while (firstHalf > 0) { // 12
            result = result * 10 + firstHalf % 10; // -> 1220 + 2 = 1222 -> 12220 + 1 = 12221
            firstHalf = firstHalf / 10;
        }
        return result;
    }
}
