/**
 * Using Sweep-Line Algorithm
 * 
 * TC: O(N x log(N))
 * SC: O(N)
 */
class MyCalendarThree {

    private TreeMap<Integer, Integer> events;

    public MyCalendarThree() {
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
    public int book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1); // TC: O(log(N))
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);     // TC: O(log(N))
        int activeEvents = 0;
        int maxActiveEvents = Integer.MIN_VALUE;
        for (Integer key : events.keySet()) { // TC: O(N)
            activeEvents += events.get(key);  // TC: O(log(N))
            maxActiveEvents = Math.max(maxActiveEvents, activeEvents);
        }
        return maxActiveEvents;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
