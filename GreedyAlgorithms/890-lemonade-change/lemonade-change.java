class Solution {
    /**
     * Approach : Using Greedy Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for (int bill : bills) { // TC: O(N)
            if (bill == 5) {
                // no change needed so possible
                fives++;
            } else if (bill == 10) {
                // atleast one 5's change is needed
                if (fives > 0) {
                    tens++;
                    fives--;
                } else {
                    // not possible to return change value
                    return false;
                }
            } else {
                // bill == 20
                if (tens > 0) {
                    // atleast one 10's change is needed
                    if (fives > 0) {
                        // atleast one 5's change is needed
                        tens--;
                        fives--;
                    } else {
                        // not possible to return change value
                        return false;
                    }
                } else if (fives >= 3) {
                    // atleast three 5's change is needed
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
