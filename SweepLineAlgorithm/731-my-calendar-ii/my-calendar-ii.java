class MyCalendarTwo {

    Map<Integer, Integer> eventsMap = null;

    /**
     * TC: O(1)
     * SC: O(Q)
     */
    public MyCalendarTwo() {
        eventsMap = new TreeMap<Integer, Integer>();
    }
    
    /**
     * TC: O(Q x log(Q))
     * SC: O(1)
     */
    public boolean book(int startTime, int endTime) {
        eventsMap.put(startTime, eventsMap.getOrDefault(startTime, 0) + 1); // TC: O(log(Q))
        /**
         * as endTime is not included as [startTime, endTime)
         * is half-open interval i.e. startTime <= x < endTime
         */
        eventsMap.put(endTime, eventsMap.getOrDefault(endTime, 0) - 1); // TC: O(log(Q))
        int sum = 0;
        for (Integer key : eventsMap.keySet()) { // TC: O(Q)
            sum += eventsMap.get(key); // TC: O(log(Q))
            if (sum > 2) {
                /**
                 * condition for triple booking is encountered so
                 * undo map insertion for interval
                 */
                eventsMap.put(startTime, eventsMap.get(startTime) - 1); // TC: O(log(Q))
                eventsMap.put(endTime, eventsMap.get(endTime) + 1); // TC: O(log(Q))
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */
