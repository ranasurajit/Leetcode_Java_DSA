class Solution {
    /**
     * Approach II : Using Two Pointers and Sorting Approach
     *
     * TC: O(N ^ 2 + N x log(N)) ~ O(N ^ 2)
     * SC: O(1)
     *
     * Accepted (314 / 314 testcases passed)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums); // TC: O(N x log(N))
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -1 * nums[i];
            twoSum(nums, i + 1, target, result); // TC: O(N)
        }
        return result;
    }

    /**
     *
     */
    private void twoSum(int[] nums, int start, int target, List<List<Integer>> result) {
        int p = start;
        int q = nums.length - 1;
        while (p < q) {
            int sum = nums[p] + nums[q];
            if (sum < target) {
                p++;
            } else if (sum > target) {
                q--;
            } else {
                result.add(Arrays.asList(-1 * target, nums[p], nums[q]));
                while (p < q && nums[p] == nums[p + 1]) {
                    p++;
                }
                while (p < q && nums[q] == nums[q - 1]) {
                    q--;
                }
                p++;
                q--;
            }
        }
    }

    /**
     * Approach I : Using Simulation Approach
     *
     * TC: O(N ^ 3)
     * SC: O(1)
     *
     * Time Limit Exceeded (309 / 314 testcases passed)
     */
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < n - 2; i++) { // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<Integer>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet); // TC: O(3 x log(3)) ~ O(1)
                        result.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
