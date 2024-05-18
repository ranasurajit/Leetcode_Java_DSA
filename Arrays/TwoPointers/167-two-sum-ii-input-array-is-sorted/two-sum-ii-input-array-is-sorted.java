class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p = 0;
        int q = numbers.length - 1;
        int[] indices = { 0, 0 };
        while (p < q) {
            if (numbers[p] + numbers[q] == target) {
                indices[0] = p + 1;
                indices[1] = q + 1;
                break;
            } else if (numbers[p] + numbers[q] < target) {
                p++;
            } else {
                q--;
            }
        }
        return indices;
    }
}
