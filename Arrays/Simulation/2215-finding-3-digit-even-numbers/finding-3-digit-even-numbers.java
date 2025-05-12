class Solution {
    /**
     * Approach III : Using Simulation, Hashing, Sorting - Cleaner Approach
     *
     * TC: O(N ^ 3 + N x log(N) + 6 (N - 2)) ~ O(N ^ 3)
     * SC: (6 x (N - 2)) ~ O(N)
     */
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = 0; j < n; j++) {     // TC: O(N)
                for (int k = 0; k < n; k++) { // TC: O(N)
                    if(i == j || j == k || k == i) {
                        continue;
                    }
                    int nums = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (nums >= 100 && (nums & 1) == 0) {
                        set.add(nums);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>(set);
        int[] evenNumbers = new int[set.size()];
        for (int i = 0; i < evenNumbers.length; i++) { // TC: (6 x (N - 2))
            evenNumbers[i] = list.get(i);
        }
        Arrays.sort(evenNumbers); // TC: O(6 x N x log(6 x N)) ~ O(N x log(N))
        return evenNumbers;
    }

    /**
     * Approach II : Using Simulation, Hashing, Sorting Approach
     *
     * TC: O(N ^ 3 + N x log(N) + 6 (N - 2)) ~ O(N ^ 3)
     * SC: (6 x (N - 2)) ~ O(N)
     */
    public int[] findEvenNumbersApproachII(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    if (digits[i] != 0) {
                        if ((digits[k] & 1) == 0) {
                            set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                        }
                        if ((digits[j] & 1) == 0) {
                            set.add(digits[i] * 100 + digits[k] * 10 + digits[j]);
                        }
                    }
                    if (digits[j] != 0) {
                        if ((digits[k] & 1) == 0) {
                            set.add(digits[j] * 100 + digits[i] * 10 + digits[k]);
                        }
                        if ((digits[i] & 1) == 0) {
                            set.add(digits[j] * 100 + digits[k] * 10 + digits[i]);
                        }
                    }
                    if (digits[k] != 0) {
                        if ((digits[j] & 1) == 0) {
                            set.add(digits[k] * 100 + digits[i] * 10 + digits[j]);
                        }
                        if ((digits[i] & 1) == 0) {
                            set.add(digits[k] * 100 + digits[j] * 10 + digits[i]);
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>(set);
        int[] evenNumbers = new int[set.size()];
        for (int i = 0; i < evenNumbers.length; i++) { // TC: (6 x (N - 2))
            evenNumbers[i] = list.get(i);
        }
        Arrays.sort(evenNumbers); // TC: O(6 x N x log(6 x N)) ~ O(N x log(N))
        return evenNumbers;
    }

    /**
     * Approach I : Using Simulation, Hashing (TreeSet) Approach
     *
     * TC: O(N ^ 3 x log(N) + 6 (N - 2)) ~ O(N ^ 3)
     * SC: (6 x (N - 2)) ~ O(N)
     */
    public int[] findEvenNumbersApproachI(int[] digits) {
        int n = digits.length;
        Set<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < n - 2; i++) {         // TC: O(N)
            for (int j = i + 1; j < n - 1; j++) { // TC: O(N)
                for (int k = j + 1; k < n; k++) { // TC: O(N)
                    if (digits[i] != 0) { // TC: O(log(N))
                        if ((digits[k] & 1) == 0) {
                            set.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                        }
                        if ((digits[j] & 1) == 0) {
                            set.add(digits[i] * 100 + digits[k] * 10 + digits[j]);
                        }
                    }
                    if (digits[j] != 0) { // TC: O(log(N))
                        if ((digits[k] & 1) == 0) {
                            set.add(digits[j] * 100 + digits[i] * 10 + digits[k]);
                        }
                        if ((digits[i] & 1) == 0) {
                            set.add(digits[j] * 100 + digits[k] * 10 + digits[i]);
                        }
                    }
                    if (digits[k] != 0) { // TC: O(log(N))
                        if ((digits[j] & 1) == 0) {
                            set.add(digits[k] * 100 + digits[i] * 10 + digits[j]);
                        }
                        if ((digits[i] & 1) == 0) {
                            set.add(digits[k] * 100 + digits[j] * 10 + digits[i]);
                        }
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>(set);
        int[] evenNumbers = new int[list.size()];
        for (int i = 0; i < evenNumbers.length; i++) { // TC: (6 x (N - 2))
            evenNumbers[i] = list.get(i);
        }
        return evenNumbers;
    }
}
