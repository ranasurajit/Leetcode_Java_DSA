class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<Integer>();
        for (int num = 1; num <= 9; num++) {
            dfs(n - 1, k, result, num);
        }
        int[] nums = new int[result.size()];
        Iterator<Integer> iter = result.iterator();
        int index = 0;
        while (iter.hasNext()) {
            nums[index] = iter.next();
            index++;
        }
        return nums;
    }

    private void dfs(int n, int k, Set<Integer> result, int num) {
        if (n == 0) {
            result.add(num);
            return;
        }
        int lastdigit = num % 10;
        if (lastdigit + k <= 9) {
            dfs(n - 1, k, result, num * 10 + lastdigit + k);
        }
        if (lastdigit - k >= 0) {
            dfs(n - 1, k, result, num * 10 + lastdigit - k);
        }
    }
}