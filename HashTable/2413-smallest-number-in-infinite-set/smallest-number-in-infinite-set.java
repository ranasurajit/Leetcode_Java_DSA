class SmallestInfiniteSet {
    private boolean[] set = null;
    private int sIndex = 1;

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public SmallestInfiniteSet() {
        set = new boolean[1001]; // SC: O(1000) ~ O(1)
        Arrays.fill(set, true);
        set[0] = false; // as set contains only positive integers
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int popSmallest() {
        int smallest = sIndex;
        set[sIndex] = false;
        while (sIndex < set.length && !set[sIndex]) { // TC: O(N)
            sIndex++;
        }
        return smallest;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void addBack(int num) {
        if (!set[num]) {
            set[num] = true;
            if (sIndex > num) {
                sIndex = num;
            }
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
