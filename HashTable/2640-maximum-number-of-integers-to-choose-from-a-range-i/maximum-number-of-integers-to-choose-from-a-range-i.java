class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int item : banned) {
            hs.add(item);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!hs.contains(i) && sum + i <= maxSum) {
                sum += i;
                list.add(i);
            }
        }
        return list.size();
    }

    // private int validSum(int n, int maxSum, ArrayList<Integer> list) {
    //     int sum = 0;
    //     for (int i = 1; i <= n; i++) {
    //         if (!hs.contains(i)) {
    //             sum += i;
    //         }
    //     }
    // }
}
