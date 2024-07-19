class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rMinMax = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int rMin = Integer.MAX_VALUE;
            for (int j = 0; j < cols; j++) {
                rMin = Math.min(rMin, matrix[i][j]);
            }
            rMinMax = Math.max(rMinMax, rMin);
        }
        int cMaxMin = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            int cMax = Integer.MIN_VALUE;
            for (int j = 0; j < rows; j++) {
                cMax = Math.max(cMax, matrix[j][i]);
            }
            cMaxMin = Math.min(cMaxMin, cMax);
        }
        List<Integer> luckyNum = new ArrayList<Integer>();
        if (rMinMax == cMaxMin) {
            luckyNum.add(rMinMax);
        }
        return luckyNum;
    }
}
