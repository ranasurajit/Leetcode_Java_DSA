class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        // Max-heap containing double { delta, index } - SC: O(N)
        PriorityQueue<double[]> pq = new PriorityQueue<double[]>((p, q) -> {
            return Double.compare(q[0], p[0]);
        });
        // Initialize the priority queue with the delta values and indices
        for (int i = 0; i < n; i++) {
            double pr = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPR - pr;
            pq.offer(new double[] { delta, i });
        }
        // Allocate extra students
        while (extraStudents > 0) {
            double[] current = pq.poll();
            int idx = (int) current[1];
            // updating classes to add extra student
            classes[idx][0]++;
            classes[idx][1]++;
            // calculating delta after adding student and modifying the PriorityQueue
            int pass = classes[idx][0];
            int total = classes[idx][1];
            double pr = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double delta = newPR - pr;
            pq.offer(new double[] { delta, idx });
            extraStudents--;
        }
        // Calculate the final average pass ratio
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }
        return result / n;
    }
}
