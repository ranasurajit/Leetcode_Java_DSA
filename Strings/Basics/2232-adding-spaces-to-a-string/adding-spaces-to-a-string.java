class Solution {
    public String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;
        int start = 0;
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i < n; i++) {
            int end = spaces[i];
            queue.offer(s.substring(start, end));
            start = end;
        }
        queue.offer(s.substring(start, m));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
