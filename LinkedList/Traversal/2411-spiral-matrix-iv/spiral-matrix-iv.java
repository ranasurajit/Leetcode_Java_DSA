/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * TC: O (M x N + Min(M x N, K)) ~ O(M x N) as K lies in [1, m * n]
     * SC: O(1) - Not considering output matrix
     */
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] matRow : matrix) { // TC: O (M x N)
            Arrays.fill(matRow, -1);
        }
        int direction = 0, top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (head != null) { // TC: O (Min(M x N, K)) where K = length of LinkedList
            if (direction == 0) {
                for (int i = left; i <= right && head != null; i++) {
                    matrix[top][i] = head.val;
                    head = head.next;
                }
                top++;
            } else if (direction == 1 && head != null) {
                for (int i = top; i <= bottom && head != null; i++) {
                    matrix[i][right] = head.val;
                    head = head.next;
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left && head != null; i--) {
                    matrix[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top && head != null; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}
