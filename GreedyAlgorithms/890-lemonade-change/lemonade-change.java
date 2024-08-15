class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                // increment 5
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    // decrement 5 as change given back to customer
                    five--;
                    // increment 10
                    ten++;
                } else {
                    // no change left
                    return false;
                }
            } else if (bill == 20) {
                if (five > 0 && ten > 0) {
                    // both 5 and 10 changes left
                    ten--;
                    five--;
                } else if (five >= 3 && ten == 0) {
                    // 5 changes >= 3 and 10 changes not left
                    five -= 3;
                } else {
                    // no change left
                    return false;
                }
            }
        }
        return true;
    }
}
