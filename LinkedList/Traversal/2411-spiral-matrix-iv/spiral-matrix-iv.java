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
        if (head == null) {
            return matrix;
        }
        int direction = 0;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (head != null) { // TC: O (Min(M x N, K)) where K = length of LinkedList
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    if (head != null) {
                        matrix[top][i] = head.val;
                        head = head.next;
                    }
                }
                top++;
            } else if (direction == 1 && head != null) {
                for (int i = top; i <= bottom; i++) {
                    if (head != null) {
                        matrix[i][right] = head.val;
                        head = head.next;
                    }
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    if (head != null) {
                        matrix[bottom][i] = head.val;
                        head = head.next;
                    }
                }
                bottom--;
            } else if (direction == 3) {
                for (int i = bottom; i >= top; i--) {
                    if (head != null) {
                        matrix[i][left] = head.val;
                        head = head.next;
                    }
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}
