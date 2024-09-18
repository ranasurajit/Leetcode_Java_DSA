class Solution {
    /**
     * TC: O(2N + K x Nlog(N)) ~ O(K x Nlog(N))
     * SC: O(3N) ~ O(N)
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] convertedNums = new String[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            convertedNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(convertedNums, new Comparator<String>() { // TC: O(Nlog(N))
            @Override
            public int compare(String a, String b) {
                String first = a + b;
                String second = b + a;
                return second.compareTo(first); // TC: O(K), SC: O(N) where K = length of Strings in comparison
            }
        });
        if (convertedNums[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            sb.append(convertedNums[i]);
        }
        return new String(sb);
    }
}
