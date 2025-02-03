/**
 * Using Stack Approach
 *
 * TC: O(N)
 * SC: O(1)
 */
class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<int[]>();
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     * 
     * @param price
     * @return
     */
    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && price >= st.peek()[0]) { // TC: O(N)
            span += st.pop()[1];
        }
        st.push(new int[] { price, span });
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
