/**
 * Using Sweep-Line Algorithm
 * 
 * TC: O(N x log(N))
 * SC: O(N)
 */
class MyCalendarTwo {

    private TreeMap<Integer, Integer> events;

    public MyCalendarTwo() {
        events = new TreeMap<>();
    }
    
    /**
     * TC: O(N x log(N))
     * SC: O(1)
     * 
     * @param startTime
     * @param endTime
     * @return
     */
    public boolean book(int start, int end) {
        // Mark the event in the timeline
        events.put(start, events.getOrDefault(start, 0) + 1);
        events.put(end, events.getOrDefault(end, 0) - 1);

        int activeEvents = 0;
        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            activeEvents += entry.getValue();
            if (activeEvents > 2) {
                // Undo the booking if triple overlap detected
                events.put(start, events.get(start) - 1);
                if (events.get(start) == 0) events.remove(start);
                events.put(end, events.get(end) + 1);
                if (events.get(end) == 0) events.remove(end);
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
