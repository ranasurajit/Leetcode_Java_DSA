class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double timeArr = customers[0][0]; // time of arrival
        double timeCook = customers[0][1]; // time to cook
        double timeCookFree = timeArr + timeCook; // time when cook is free
        double waitingTime = timeCookFree - timeArr;
        for (int i = 1; i < n; i++) {
            timeCookFree = Math.max(timeCookFree, customers[i][0]);
            timeCookFree += customers[i][1];
            waitingTime += timeCookFree - customers[i][0];
        }
        return waitingTime / n;
    }
}
