class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    Long sum = 
                        Long.valueOf(nums[i]) + 
                        Long.valueOf(nums[j]) + 
                        Long.valueOf(nums[k]) + 
                        Long.valueOf(nums[l]);
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        // sum equals target
                        Integer[] quadruplet = { nums[i], nums[j], nums[k], nums[l] };
                        List<Integer> quadList = Arrays.asList(quadruplet);
                        result.add(quadList);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
