class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> monoStack = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.isEmpty() && temperatures[i] > temperatures[monoStack.peek()]) {
                int popped = monoStack.pop();
                result[popped] = i - popped;
            }
            monoStack.add(i);
        }
        return result;
    }
}
