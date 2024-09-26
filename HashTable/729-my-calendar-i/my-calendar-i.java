/**
* TC: O(Nlog(N))
* SC: O(N)
*/
class MyCalendar {

    TreeSet<int[]> ts;

    /**
     * TC: O(Nlog(N))
     * SC: O(N)
     */
    public MyCalendar() {
        // custom comparator to sort intervals based upon start or end of two events
        ts = new TreeSet<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
    }
    
    /**
     * TC: O(Nlog(N))
     * SC: O(1)
     */
    public boolean book(int start, int end) {
        int[] event = new int[] { start, end };
        int[] prev = ts.floor(event); // TC: O(log(N))
        int[] next = ts.ceiling(event); // TC: O(log(N))
        // check for overlapping with previous slot
        if (prev != null && prev[1] > start) {
            return false;
        }
        // check for overlapping with next slot
        if (next != null && next[0] < end) {
            return false;
        }
        // add the event to TreeSet as no overlap is detected
        ts.add(event); // TC: O(log(N))
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
