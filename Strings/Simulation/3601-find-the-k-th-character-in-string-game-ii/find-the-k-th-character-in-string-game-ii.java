class Solution {
    /**
     * Approach II : Using Offset Shifting Approach
     *
     * TC: O(N) + O(N)
     * SC: O(N)
     *
     * Time Limit Exceeded (744 / 901 testcases passed)
     */
    public char kthCharacter(long k, int[] operations) {
        int shift = 0;
        List<Long> lengthStr = new ArrayList<Long>(); // SC: O(N)
        long len = 1;
        for (int operation : operations) { // TC: O(N)
            len = len * 2;
            lengthStr.add(len);
            if (len >= k) {
                break;
            }
        }
        for (int i = lengthStr.size() - 1; i >= 0; i--) { // TC: O(N)
            long half = lengthStr.get(i) / 2;
            int operation = operations[i];
            if (k > half) {
                k -= half;
                if (operations[i] == 1) {
                    shift++;
                }
            }
        }
        return (char) ((shift % 26) + 'a');
    }

    /**
     * Approach I : Using Brute-Force Approach
     *
     * TC: O(K x K)
     * SC: O(K)
     *
     * Time Limit Exceeded (744 / 901 testcases passed)
     */
    public char kthCharacterBruteForce(long k, int[] operations) {
        StringBuilder sb = new StringBuilder("a"); // SC: O(K)
        int idx = 0;
        while (sb.length() < k) { // TC: O(K)
            int size = sb.length();
            for (int i = 0; i < size; i++) { // TC: O(K)
                if (operations[idx] == 0) {
                    sb.append(sb.charAt(i));
                } else {
                    char ch = (char) ('a' + (sb.charAt(i) - 'a' + 1) % 26);
                    sb.append(ch);
                }
            }
            idx++;
        }
        return sb.charAt((int) k - 1);
    }
}
