/**
 * Using Sweep-Line Algorithm
 * 
 * TC: O(N x log(N))
 * SC: O(N)
 */
class MyCalendarTwo {

    private TreeMap<Integer, Integer> events = null;

    public MyCalendarTwo() {
        events = new TreeMap<Integer, Integer>();
    }
    
    /**
     * TC: O(N x log(N))
     * SC: O(1)
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean book(int startTime, int endTime) {
        // increment start time by +1 and decrement end time (excluded) by -1
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int activeEvents = 0; // calculate cumulative sum for all keys
        for (Integer key : events.keySet()) { // TC: O(N)
            activeEvents += events.get(key);
            if (activeEvents > 2) {
                /**
                    * there is a triple booking then undo the
                    * last operation done for start and end time
                    */
                events.put(startTime, events.get(startTime) - 1); // TC: O(log(N))
                if (events.get(startTime) == 0) {
                    events.remove(startTime);
                }
                events.put(endTime, events.get(endTime) + 1); // TC: O(log(N))
                if (events.get(endTime) == 0) {
                    events.remove(endTime);
                }
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
