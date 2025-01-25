class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    /**
     * TC: O(N x log(N))
     * SC: O(N)
     */
    public boolean book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime, 0) + 1); // TC: O(log(N))
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);     // TC: O(log(N))
        int sum = 0;
        for (Integer key : map.keySet()) { // TC: O(N)
            sum += map.get(key);
            if (sum > 1) {
                // undo the book operation due to double booking
                map.put(startTime, map.get(startTime) - 1); // TC: O(log(N))
                map.put(endTime, map.get(endTime) + 1);     // TC: O(log(N))
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
