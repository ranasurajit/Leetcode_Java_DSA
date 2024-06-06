class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> treeMap = new TreeMap<Integer, Double>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            int distance = target - position[i];
            // speed = distance / time
            double time = (double) distance / speed[i];
            treeMap.put(position[i], time);
        }
        Stack<Double> st = new Stack<Double>();
        while (treeMap.size() > 0) {
            int key = treeMap.firstKey();
            double current = treeMap.get(key);
            double prev = Double.MIN_VALUE;
            if (st.size() > 0) {
                prev = st.peek();
            }
            if (current > prev) {
                st.add(current);
            }
            treeMap.remove(key);
        }
        return st.size();
    }
}
