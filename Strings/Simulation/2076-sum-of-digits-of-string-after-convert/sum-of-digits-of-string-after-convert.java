class Solution {

    /**
     * TC: O(N + k x N) ~ O(k x N) ~ O(N) as 1 <= k <= 10
     * SC: O(1)
     */
    public int getLucky(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) { // TC: O(N)
            int index = (int) (s.charAt(i) - 'a') + 1;
            sb.append(String.valueOf(index));
        }
        int result = 0;
        for (int i = 0; i < k; i++) { // TC: O(k x N)
            sb = transform(sb);
        }
        return Integer.valueOf(sb.toString());
    }

    private StringBuilder transform(StringBuilder s) {
        long result = 0L;
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            long value = s.charAt(i) - '0';
            result += value;
        }
        return new StringBuilder(String.valueOf(result));
    }
}
