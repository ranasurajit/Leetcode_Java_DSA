class Solution {
    /**
     * Approach : Using Min Heap (PriorityQueues) + Sorting Approach
     *
     * TC: O(N) + O(N x log(N)) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N) + O(N) ~ O(N)
     */
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        List<Process> taskList = new ArrayList<Process>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            taskList.add(new Process(tasks[i][0], tasks[i][1], i));
        }
        /**
         * We need to sort the tasks based upon the enqueueTime
         */
        Collections.sort(taskList, (a, b) -> a.startTime - b.startTime); // TC: O(N x log(N))
        /**
         * We need to use a PriorityQueue (Min-Heap) to find which task would CPU
         * be preferring, when multiple tasks are given to it (when CPU is idle)
         */
        PriorityQueue<Process> pq = new PriorityQueue<Process>((p, q) -> {
            if (p.duration == q.duration) {
                return p.index - q.index;
            }
            return p.duration - q.duration;
        }); // SC: O(N)
        int i = 0;
        int tIdx = 0;
        int time = 0;
        int[] taskOrder = new int[n];
        while (!pq.isEmpty() || i < n) { // TC: O(N)
            if (pq.isEmpty() && time < taskList.get(i).startTime) {
                time = taskList.get(i).startTime;
            }
            while (i < n && time >= taskList.get(i).startTime) {
                // CPU pooling
                pq.offer(taskList.get(i)); // TC: O(log(N))
                i++;
            }
            // poll the elements out of PriorityQueue
            Process current = pq.poll();
            time += current.duration;
            taskOrder[tIdx++] = current.index;
        }
        return taskOrder;
    }

    class Process {
        int startTime;
        int duration;
        int index;

        public Process(int startTime, int duration, int index) {
            this.startTime = startTime;
            this.duration = duration;
            this.index = index;
        }
    }
}
