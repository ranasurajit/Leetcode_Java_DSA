/**
 * Using Lazy Update in PriorityQueue
 *
 * TC: O(log(N))
 * SC: O(N)
 */
class NumberContainers {

    private Map<Integer, Integer> indexMap;
    private Map<Integer, PriorityQueue<Integer>> sortedMap;

    /**
     * TC: O(1)
     * SC: O(2 x N) ~ O(N)
     */
    public NumberContainers() {
        indexMap = new HashMap<Integer, Integer>();
        // we need a min-heap to return the smallest index
        sortedMap = new HashMap<Integer, PriorityQueue<Integer>>();
    }
    
    /**
     * TC: O(log(N))
     * SC: O(1)
     */
    public void change(int index, int number) {
        indexMap.put(index, number);
        sortedMap.computeIfAbsent(number, 
            k -> new PriorityQueue<Integer>()).offer(index); // TC: O(log(N))
    }
    
    /**
     * Using Lazy Update in PriorityQueue
     *
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public int find(int number) {
        if (!sortedMap.containsKey(number)) {
            return -1;
        }
        PriorityQueue<Integer> queue = sortedMap.get(number);
        while(!queue.isEmpty()) {
            int current = queue.peek(); // TC: O(log(N))
            if (indexMap.get(current) == number) {
                return current;
            }
            queue.poll();              // TC: O(log(N))
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
