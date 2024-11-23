class Solution {
    /**
     * TC: O(3 x M x N) ~ O(M x N)
     * SC: O(1)
     */
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] rotatedBox = new char[n][m];
        // transpose the grid box to rotatedBox
        for (int row = m - 1; row >= 0; row--) { // TC: O(M)
            for (int col = 0; col < n; col++) {  // TC: O(N)
                rotatedBox[col][row] = box[row][col];
            }
        }
        // reverse the elements of each row
        for (char[] row : rotatedBox) { // TC: O(M)
            reverse(row);               // TC: O(N)
        }
        // applying grapvity after 90 degree rotation for rotatedBox (n x m)
        for (int col = 0; col < m; col++) {          // TC: O(M)
            int spaceRow = n - 1;
            for (int row = n - 1; row >= 0; row--) { // TC: O(N)
                if (rotatedBox[row][col] == '*') {
                    // obstacle found
                    spaceRow = row - 1;
                    continue;
                } else if (rotatedBox[row][col] == '#') {
                    // stone found
                    rotatedBox[row][col] = '.';
                    rotatedBox[spaceRow][col] = '#';
                    spaceRow--;
                }
            }
        }
        return rotatedBox;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     */
    private void reverse(char[] row) {
        int start = 0;
        int end = row.length - 1;
        while (start < end) {
            char temp = row[end];
            row[end] = row[start];
            row[start] = temp;
            start++;
            end--;
        }
    }
}
