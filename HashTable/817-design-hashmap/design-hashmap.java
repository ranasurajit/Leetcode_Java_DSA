/**
 * Approach : Using an Array Approach
 *
 * TC: O(1)
 * SC: O(1)
 */
class MyHashMap {

    int[] nums = new int[(int) 1e6 + 1];

    /**
     * TC: O(1)
     * SC: O(1e6 + 1) ~ O(1)
     */
    public MyHashMap() {
        Arrays.fill(nums, -1);
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void put(int key, int value) {
        nums[key] = value;
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int get(int key) {
        return nums[key];
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void remove(int key) {
        nums[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
