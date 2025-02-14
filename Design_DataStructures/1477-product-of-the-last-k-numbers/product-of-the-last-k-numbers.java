class ProductOfNumbers {

    private List<Integer> added = null;
    private int n = 0;

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public ProductOfNumbers() {
        added = new ArrayList<Integer>();
        n = 0;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void add(int num) {
        added.add(num);
        n++;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int getProduct(int k) {
        int product = 1;
        while(k-- > 0) {
            product *= added.get(n - k - 1);
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
