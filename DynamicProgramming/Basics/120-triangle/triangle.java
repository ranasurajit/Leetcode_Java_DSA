class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        List<Integer> dp = triangle.get(rows - 1);
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int currentSum = triangle.get(i).get(j) + 
                    Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
                triangle.get(i).set(j, currentSum);
            }
        }
        return triangle.get(0).get(0);
    }
}
