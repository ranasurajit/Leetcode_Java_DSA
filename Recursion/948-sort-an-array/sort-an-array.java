class Solution {
    public int[] sortArray(int[] nums) {
        // List<Integer> list = new ArrayList<Integer>();
        // for (int num : nums) {
        //     list.add(num);
        // }
        // // sortArrayRecursion(list, list.size());
        // sortArrayMultiRecursion(list, list.size());
        // int index = 0;
        // for (Integer it : list) {
        //     nums[index++] = it;
        // }
        Arrays.sort(nums);
        return nums;
    }

    private void sortArrayMultiRecursion(List<Integer> list, int n) {
        // Base Case
        if (n == 1) {
            // it is self sorted
            return;
        }
        // Hypothesis
        int lastValue = list.remove(n - 1);
        sortArrayMultiRecursion(list, n - 1);
        insertIntoSortedArray(list, lastValue);
    }

    private void insertIntoSortedArray(List<Integer> list, int element) {
        // Base Case
        if (list.size() == 0 || element >= list.get(list.size() - 1)) {
            // append element
            list.add(element);
            return;
        }
        // Hypotheses - expect that it will have inserted element in (n - 1) size
        int last = list.remove(list.size() - 1);
        insertIntoSortedArray(list, element);
        // Induction - add last to the list
        list.add(last);
    }

    private void sortArrayRecursion(List<Integer> list, int n) {
        // Base case
        if (n == 1) {
            // it is self sorted
            return;
        }
        // Hypothesis
        // expect the sortArray method to sort elements from index 0 to (n - 2)
        int lastValue = list.get(n - 1);
        sortArrayRecursion(list, n - 1);
        // Induction
        // we need to place the lastValue in its sorted position
        int idx = n - 2;
        while (idx >= 0 && lastValue < list.get(idx)) {
            list.set(idx + 1, list.get(idx));
            idx--;
        }
        // we need to place lastValue in its position (idx + 1)
        list.set(idx + 1, lastValue);
    }
}
