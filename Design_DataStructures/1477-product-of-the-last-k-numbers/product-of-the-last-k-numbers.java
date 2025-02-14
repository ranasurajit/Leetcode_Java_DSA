class ProductOfNumbers {

    private List<Integer> added = null;
    private int product = 1;

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public ProductOfNumbers() {
        added = new ArrayList<Integer>();
        product = 1;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void add(int num) {
        if (num == 0) {
            // reset the added array to zero
            added = new ArrayList<Integer>();
            product = 1;
            return;
        }
        product = product * num;
        added.add(product);
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int getProduct(int k) {
        int n = added.size();
        if (n < k) {
            return 0;
        }
        int result = added.get(n - 1);
        if (n == k) {
            return result;
        }
        return result / added.get(n - 1 - k);
    }
}

class ProductOfNumbersBruteForce {

    private List<Integer> added = null;
    private int n = 0;

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public ProductOfNumbersBruteForce() {
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
