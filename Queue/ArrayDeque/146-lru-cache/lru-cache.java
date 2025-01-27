/**
 * Using HashMap and ArrayDeque
 *
 * TC: O(1)
 * SC: O(1)
 */
class LRUCache {
    private ArrayDeque<Integer> deque = null;
    private Map<Integer, Integer> map;
    private int n = 0;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        deque = new ArrayDeque<Integer>();
        n = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addLast(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deque.remove(key);
        } else {
            if (map.size() >= n) {
                int leastUsedKey = deque.pollFirst();
                map.remove(leastUsedKey);
            }
        }
        map.put(key, value);
        deque.addLast(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
