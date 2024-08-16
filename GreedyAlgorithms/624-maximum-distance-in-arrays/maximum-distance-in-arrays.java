class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int distance = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);
            distance = Math.max(distance, Math.max(Math.abs(max - currentMin), Math.abs(currentMax - min)));
            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }
        return distance;
    }
}
