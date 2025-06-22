class Solution {
    /**
     * Approach : Using String Simulation
     *
     * TC: O(N + K)
     * SC: O(1)
     */
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int xNeeded = n % k == 0 ? 0 : k - (n % k);
        for (int i = 0; i < xNeeded; i++) { // TC: O(K)
            s += String.valueOf(fill);
        }
        n = s.length();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i+=k) {     // TC: O(N / K)
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {  // TC: O(K)
                sb.append(s.charAt(i + j));
            }
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }
}
