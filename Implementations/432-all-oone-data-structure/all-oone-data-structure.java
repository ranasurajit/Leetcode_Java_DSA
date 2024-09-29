/**
 * TC: O(1)
 * SC: O(2N) ~ O(N)
 */
class AllOne {
    HashMap<String, Integer> countMap;
    TreeMap<Integer, HashSet<String>> freqMap;

    /**
     * TC: O(1)
     */
    public AllOne() {
        countMap = new HashMap<String, Integer>();
        freqMap = new TreeMap<Integer, HashSet<String>>();
    }
    
    /**
     * TC: O(1)
     */
    public void inc(String key) {
        int freq = countMap.getOrDefault(key, 0);
        if (freq != 0) {
            freqMap.getOrDefault(freq, new HashSet<String>()).remove(key);
            if (freqMap.containsKey(freq) && freqMap.get(freq).isEmpty()) {
                freqMap.remove(freq);
            }
        }
        freqMap.put(freq + 1, freqMap.getOrDefault(freq + 1, new HashSet<String>()));
        freqMap.get(freq + 1).add(key);
        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
    }
    
    /**
     * TC: O(1)
     */
    public void dec(String key) {
        int freq = countMap.getOrDefault(key, 0);
        if (freqMap.containsKey(freq)) {
            freqMap.get(freq).remove(key);
            if (freqMap.get(freq).isEmpty()) {
                freqMap.remove(freq);
            }
        }
        freq--;
        if (freq != 0) {
            freqMap.put(freq, freqMap.getOrDefault(freq, new HashSet<String>()));
            freqMap.get(freq).add(key);
            countMap.put(key, freq);
        } else {
            countMap.remove(key);
        }
    }
    
    /**
     * TC: O(1)
     */
    public String getMaxKey() {
        if (freqMap.isEmpty()) {
            return "";
        }
        HashSet<String> hs = freqMap.get(freqMap.lastKey());
        return hs.iterator().next();
    }
    
    /**
     * TC: O(1)
     */
    public String getMinKey() {
        if (freqMap.isEmpty()) {
            return "";
        }
        HashSet<String> hs = freqMap.get(freqMap.firstKey());
        return hs.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
