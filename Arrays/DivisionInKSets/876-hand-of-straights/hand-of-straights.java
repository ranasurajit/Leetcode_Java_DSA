class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for (int it : hand) {
            tm.put(it, tm.getOrDefault(it, 0) + 1);
        }
        while (tm.size() > 0) {
            int minimum = tm.firstKey();
            for (int i = minimum; i < minimum + groupSize; i++) {
                if (!tm.containsKey(i)) {
                    return false;
                }
                int count = tm.get(i);
                if (count == 1) {
                    tm.remove(i);
                } else {
                    tm.put(i, tm.get(i) - 1);
                }
            }
        }
        return true;
    }
}
