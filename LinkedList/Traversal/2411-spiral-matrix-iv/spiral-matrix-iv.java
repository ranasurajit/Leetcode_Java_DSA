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
        ListNode current = head;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (current != null) { // TC: O (Min(M x N, K)) where K = length of LinkedList
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    if (current != null) {
                        matrix[top][i] = current.val;
                        current = current.next;
                    }
                }
                top++;
            } else if (direction == 1 && current != null) {
                for (int i = top; i <= bottom; i++) {
                    if (current != null) {
                        matrix[i][right] = current.val;
                        current = current.next;
                    }
                }
                right--;
            } else if (direction == 2 && current != null) {
                for (int i = right; i >= left; i--) {
                    if (current != null) {
                        matrix[bottom][i] = current.val;
                        current = current.next;
                    }
                }
                bottom--;
            } else if (direction == 3 && current != null) {
                for (int i = bottom; i >= top; i--) {
                    if (current != null) {
                        matrix[i][left] = current.val;
                        current = current.next;
                    }
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return matrix;
    }
}
