class Solution {
    /**
     * Approach II : Using Sorting and Two Pointers Approach
     *
     * TC: O(N ^ 3 + N x log(N)) ~ O(N ^ 3)
     * SC: O(N)
     *
     * Accepted (294 / 294 testcases passed)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>(); // SC: O(N)
        // since we need only numbers and not index so order does not matter
        Arrays.sort(nums); // TC: O(N x log(N))
        for (int i = 0; i < n - 3; i++) { // TC: O(N)
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            long reqdSum = target - nums[i];
            threeSum(i + 1, nums, reqdSum, (long) nums[i], result); // TC: O(N ^ 2)
        }
        return new ArrayList<List<Integer>>(result);
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    private void threeSum(int start, int[] nums, long target, long current,
        Set<List<Integer>> result) {
        for (int i = start; i < nums.length - 2; i++) { // TC: O(N)
            long reqdSum = target - nums[i];
            twoSum(i + 1, nums, reqdSum, current, nums[i], result); // TC: O(N), SC: O(1)
        }
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private void twoSum(int start, int[] nums, long target, long prev, long current,
        Set<List<Integer>> result) {
        int p = start;
        int q = nums.length - 1;
        while (p < q) {
            if (nums[p] + nums[q] == target) {
                result.add(Arrays.asList((int) prev, (int) current, nums[p], nums[q]));
                while (p < q && nums[p] == nums[p + 1]) {
                    p++;
                }
                while (p < q && nums[q] == nums[q - 1]) {
                    q--;
                }
                p++;
                q--;
            } else if (nums[p] + nums[q] < target) {
                p++;
            } else {
                q--;
            }
        }
    }

    /**
     * Approach I : Brute-Force (Using Simulation) Approach
     *
     * TC: O(N ^ 4)
     * SC: O(1)
     *
     * Time Limit Exceeded (288 / 294 testcases passed)
     */
    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < n - 3; i++) { // TC: O(N)
            for (int j = i + 1; j < n - 2; j++) { // TC: O(N)
                for (int k = j + 1; k < n - 1; k++) { // TC: O(N)
                    for (int l = k + 1; l < n; l++) { // TC: O(N)
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = 
                                Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(list); // TC: O(4 x log(4)) ~ O(1)
                            result.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
