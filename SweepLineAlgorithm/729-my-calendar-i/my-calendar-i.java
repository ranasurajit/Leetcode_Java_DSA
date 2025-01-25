/**
 * Using Sweep-Line Algorithm
 * 
 * TC: O(N x log(N))
 * SC: O(N)
 */
class MyCalendar {

    TreeMap<Integer, Integer> map = null;

    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
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
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int sum = 0; // calculate cumulative sum for all keys
        for (Integer key : map.keySet()) { // TC: O(N)
            sum += map.get(key);
            if (sum > 1) {
                /**
                    * there is a double booking then undo the
                    * last operation done for start and end time
                    */
                map.put(startTime, map.get(startTime) - 1); // TC: O(log(N))
                map.put(endTime, map.get(endTime) + 1); // TC: O(log(N))
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */
