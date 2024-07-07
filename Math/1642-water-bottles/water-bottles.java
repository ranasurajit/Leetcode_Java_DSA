class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int maxBottles = numBottles;
        int rem = 0;
        while (numBottles > 0) {
            numBottles = rem + numBottles;
            rem = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            maxBottles += numBottles; 
        }
        return maxBottles;
    }
}
