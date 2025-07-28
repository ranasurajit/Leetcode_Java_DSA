/**
 * Approach : Using ArrayDeques + Hashing Approach
 *
 * TC: O(N) 
 * SC: O(N) + O(N) ~ O(N)
 */
class LRUCache {
    int capacity;
    ArrayDeque<Integer> deque;
    Map<Integer, Integer> map;

    /**
     * TC: O(1)
     * SC: O(N) + O(N) ~ O(N)
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<Integer>();
        this.map = new HashMap<Integer, Integer>();
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        deque.remove(key); // TC: O(N)
        deque.addLast(key);
        return value;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key); // TC: O(N)
            deque.addLast(key);
            map.put(key, value);
            return;
        }
        if (map.size() >= capacity) {
            map.remove(deque.pollFirst());
        }
        deque.addLast(key);
        map.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
