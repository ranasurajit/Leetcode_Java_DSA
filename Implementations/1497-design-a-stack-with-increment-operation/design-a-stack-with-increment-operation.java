/**
* TC: O(N)
* SC: O(N)
*/
class CustomStack {

    Stack<Integer> st; // SC: O(N)
    int size;

    public CustomStack(int maxSize) {
        st = new Stack<Integer>();
        size = maxSize;
    }
    
    /**
     * TC: O(1)
     */
    public void push(int x) {
        if (st.size() < size) {
            st.push(x);
        }
    }
    
    /**
     * TC: O(1)
     */
    public int pop() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.pop();
    }
    
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<Integer>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        int count = 0;
        while (!temp.isEmpty()) {
            if (count < k) {
                st.push(temp.pop() + val);
            } else {
                st.push(temp.pop());
            }
            count++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
