class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        // Lambda function to sort indices on the basis of increasing order of positions
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);
        List<Integer> result = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int index : indices) {
            // robots approaching from right
            if (directions.charAt(index) == 'R') {
                st.push(index);
            } else {
                // robots approaching from left
                while (!st.isEmpty() && healths[index] > 0) {
                    int topIndex = st.pop();
                    if (healths[topIndex] > healths[index]) {
                        healths[topIndex] -= 1;
                        healths[index] = 0;
                        st.push(topIndex);
                    } else if (healths[topIndex] < healths[index]) {
                        healths[topIndex] = 0;
                        healths[index] -= 1;
                    } else {
                        // healths[topIndex] == healths[index]
                        healths[topIndex] = 0;
                        healths[index] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        return result;
    }
}
