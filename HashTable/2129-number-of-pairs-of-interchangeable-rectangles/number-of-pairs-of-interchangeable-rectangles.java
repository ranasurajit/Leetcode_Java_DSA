class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        Map<Double, Long> hm = new HashMap<Double, Long>();
        long count = 0L;
        for (int i = 0; i < n; i++) {
            double ratio = (double) rectangles[i][0] / rectangles[i][1];
            count += hm.getOrDefault(ratio, 0L);
            hm.put(ratio, hm.getOrDefault(ratio, 0L) + 1);
        }
        return count;
    }
}
