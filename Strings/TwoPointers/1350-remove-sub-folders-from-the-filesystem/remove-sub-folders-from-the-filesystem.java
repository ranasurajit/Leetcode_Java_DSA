class Solution {
    /**
     * Approach : Using Stack + String Simulation + Two Pointers Approach
     *
     * TC: O(N x log(N)) + O(N x N) + O(2 x N) ~ O(N x N)
     * SC: O(N) 
     */
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        List<String> result = new ArrayList<String>();
        Arrays.sort(folder, (a, b) -> a.compareTo(b)); // TC: O(N x log(N))
        Stack<String> st = new Stack<String>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (st.isEmpty() || !isBStringOfA(folder[i], st.peek() + "/")) { // TC: O(N)
                st.push(folder[i]);
            }
        }
        while (!st.isEmpty()) { // TC: O(N)
            result.add(st.pop());
        }
        reverse(result); // TC: O(N)
        return result;
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(Min(Length(a, b)))
     * SC: O(1)
     */
    private boolean isBStringOfA(String a, String b) {
        int p = 0; // pointer at start of String a
        int q = 0; // pointer at start of String b
        int m = a.length();
        int n = b.length();
        while (q < n) {
            if (a.charAt(p) != b.charAt(q)) {
                return false;
            }
            p++;
            q++;
        }
        return q == n;
    }

    /**
     * Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    private void reverse(List<String> result) {
        int p = 0;
        int q = result.size() - 1;
        while (p < q) {
            String temp = result.get(q);
            result.set(q, result.get(p));
            result.set(p, temp);
            p++;
            q--;
        }
    }
}
