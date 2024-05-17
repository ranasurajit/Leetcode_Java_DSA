class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];

        for (int i = 0; i < n ; i++) {
            int index = citations[i];
            if (index >= n) {
                papers[n]++;
            } else {
                papers[index]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count += papers[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
