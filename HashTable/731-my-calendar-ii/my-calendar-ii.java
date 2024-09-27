/**
 * TC: O(N)
 * SC: O(N)
 */
class MyCalendarTwo {
    List<int[]> booking;
    List<int[]> doubleBooking;

    public MyCalendarTwo() {
        booking = new ArrayList<int[]>(); // SC: O(N)
        doubleBooking = new ArrayList<int[]>(); // SC: O(N)
    }
    
    public boolean book(int start, int end) {
        int[] event = new int[] { start, end };
        for (int[] region : doubleBooking) { // TC: O(N)
            if (isOverlapped(event, region)) {
                return false;
            }
        }
        for (int[] region : booking) { // TC: O(N)
            if (isOverlapped(event, region)) {
                doubleBooking.add(getOverlappedRegion(event, region));
            }
        }
        booking.add(event);
        return true;
    }

    private boolean isOverlapped(int[] time1, int[] time2) {
        return Math.max(time1[0], time2[0]) < Math.min(time1[1], time2[1]);
    }

    private int[] getOverlappedRegion(int[] time1, int[] time2) {
        return new int[] { Math.max(time1[0], time2[0]),  Math.min(time1[1], time2[1]) };
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
