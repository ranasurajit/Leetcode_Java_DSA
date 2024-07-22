class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        Pair[] pairs = new Pair[n];
        String[] sortedNamesWithHeight = new String[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(names[i], heights[i]);
        }
        Arrays.sort(pairs, (Pair a, Pair b) -> b.height - a.height);
        for (int i = 0; i < n; i++) {
            sortedNamesWithHeight[i] = pairs[i].name;
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
