class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        /*
         * as per given constraints 
         * 1 <= books.length <= 1000
         * 1 <= thicknessi <= shelfWidth <= 1000
         * 1 <= heighti <= 1000
         */
        int[][] dp = new int[1001][1001];
        return fillShelves(0, shelfWidth, books, 0, shelfWidth, n, dp);
    }

    private int fillShelves(int index, int widthVacant, int[][] books, 
        int maxHeight, int shelfWidth, int n, int[][] dp) {
        if (index >= n) {
            return maxHeight;
        }
        if (dp[index][widthVacant] != 0) {
            return dp[index][widthVacant];
        }
        int bookWidth = books[index][0];
        int bookHeight = books[index][1];
        // pick book at index
        int pick = Integer.MAX_VALUE;
        if (widthVacant - bookWidth >= 0) {
            pick = fillShelves(index + 1, widthVacant - bookWidth, 
                books, Math.max(maxHeight, bookHeight), shelfWidth, n, dp);
        }
        // not pick book at index and put it in next shelf
        int notpick = Integer.MAX_VALUE;
        notpick = maxHeight + fillShelves(index + 1, shelfWidth - bookWidth,
            books, bookHeight, shelfWidth, n, dp);
        dp[index][widthVacant] = Math.min(pick, notpick);
        return dp[index][widthVacant];
    }
}
