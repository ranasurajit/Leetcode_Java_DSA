class Solution {
    /**
     * Approach : Using Binary Search + Greedy Approach
     * 
     * TC: O(N x log(N) + M x log(M) + K x log(K) x log(K))
     * SC: O(K)
     *
     * where K = Min(M, N), M = length(workers), N = length(tasks)
     */
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int m = workers.length;
        Arrays.sort(tasks);   // TC: O(N x log(N))
        Arrays.sort(workers); // TC: O(M x log(M))
        int low = 0;
        int high = Math.min(m, n);
        int countTasks = 0;
        // Applying Binary Search
        while (low <= high) { // TC: O(log(K))
            int mid = low + (high - low) / 2;
            if (canAssign(tasks, workers, pills, strength, m, mid)) { // TC: O(K x log(K))
                countTasks = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return countTasks;
    }

    /**
     * TC: O(K x log(K))
     * SC: O(K)
     */
    private boolean canAssign(int[] tasks, int[] workers, 
        int pills, int strength, int m, int mid) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); // SC: O(K)
        // we want best workers so we should lookup in (m - mid) to m - 1 indices
        for (int i = m - mid; i < m; i++) { // TC: O(K)
            map.put(workers[i], map.getOrDefault(workers[i], 0) + 1); // TC: O(log(K))
        }
        // we need to finish the mid number of tasks which needs less strength to complete
        for (int i = mid - 1; i >=0; i--) { // TC: O(K)
            Integer key = map.lastKey(); // TC: O(log(K))
            if (key >= tasks[i]) {
                map.put(key, map.get(key) - 1); // TC: O(log(K))
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            } else {
                // we need to apply pill and we will try to give pill to the weakest worker
                if (pills == 0) {
                    return false;
                }
                key = map.ceilingKey(tasks[i] - strength); // TC: O(log(K))
                if (key == null) {
                    return false;
                } else {
                    map.put(key, map.get(key) - 1); // TC: O(log(K))
                    if (map.get(key) == 0) {
                        map.remove(key);
                    }
                    pills--;
                }
            }
        }
        return true;
    }
}
