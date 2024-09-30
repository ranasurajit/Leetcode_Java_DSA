/**
 * TC: O(N)
 * SC: O(N)
 */
class CustomStack {
    int[] st;
    int size;
    int count;

    /**
     * TC: O(1)
     * SC: O(N)
     */
    public CustomStack(int maxSize) {
        st = new int[maxSize];
        size = maxSize;
        count = 0;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void push(int x) {
        if (count < size) {
            st[count++] = x;
        }
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int pop() {
        if (count == 0) {
            return -1;
        }
        int popped = st[count - 1];
        st[count - 1] = 0;
        count--;
        return popped;
    }
    
    /**
     * TC: O(Max(K, N))
     * SC: O(1)
     */
    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, size); i++) {
            st[i] += val;
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
