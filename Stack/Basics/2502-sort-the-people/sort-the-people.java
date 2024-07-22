class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Stack<Pair> st = new Stack<Pair>();
        String[] sortedNamesWithHeight = new String[n];
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(new Pair(names[i], heights[i]));
            } else {
                int prevHeight = st.peek().height;
                Stack<Pair> temp = new Stack<Pair>();
                while (!st.isEmpty() && st.peek().height > heights[i]) {
                    temp.push(st.pop());
                }
                st.push(new Pair(names[i], heights[i]));
                while (!temp.isEmpty()) {
                    st.push(temp.pop());
                }
            }
        }
        int count = 0;
        while (!st.isEmpty()) {
            sortedNamesWithHeight[count++] = st.pop().name;
        }
        return sortedNamesWithHeight;
    }

    class Pair {
        String name;
        int height;

        public Pair (String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
}
