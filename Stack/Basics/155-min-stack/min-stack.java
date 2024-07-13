class MinStack {

    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<Integer>();
        minSt = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty()) {
            minSt.push(val);
        } else {
            if (minSt.peek() > val) {
                minSt.push(val);
            } else {
                minSt.push(minSt.peek());
            }
        }
    }
    
    public void pop() {
        st.pop();
         minSt.pop();
    }
    
    public int top() {
        return st.isEmpty() ? 0 : st.peek();
    }
    
    public int getMin() {
        return minSt.isEmpty() ? 0 : minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
 